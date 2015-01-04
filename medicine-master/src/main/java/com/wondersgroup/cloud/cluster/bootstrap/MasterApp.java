package com.wondersgroup.cloud.cluster.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.cluster.Cluster;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.wondersgroup.cloud.cluster.actor.ClusterDomainEventListener;
import com.wondersgroup.cloud.cluster.actor.JobAcceptor;
import com.wondersgroup.cloud.medicine.model.JobRequest;
import com.wondersgroup.cloud.medicine.model.RootData;

public class MasterApp {

	private static Log logger = LogFactory.getLog(MasterApp.class);

	public static void main(String[] args) {
		final String ip = args.length > 0 ? args[0] : "localhost";
		final String port = args.length > 0 ? args[1] : "0";
		
		final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.parseString("akka.cluster.roles = [master]"))
				.withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.hostname=" + ip))
				.withFallback(ConfigFactory.load("master"));

		// Config config = ConfigFactory.load("master");

		final ActorSystem system = ActorSystem.create("medicine", config);
		logger.info("master node start");

		final RootData[] demoData = prepareData();
		// 传进来的数据本来就是json的这里就不需要解码了
		// final JSONArray json = JSONArray.fromObject(demoData);

		if (system.settings().config().getStringList("akka.cluster.roles").contains("master")) {
			Cluster.get(system).registerOnMemberUp(new Runnable() {
				@Override
				public void run() {
					ActorRef acceptor = system.actorOf(Props.create(JobAcceptor.class), "acceptor");
					logger.info("master node is ready!");
					// 暂时放弃spray-io 使用resteasy来做监听
					// ActorRef restInterface = system.actorOf(Props.create(RestInterface.class, acceptor),
					// "restinterface");
					// Http.Bind bind = new Http.Bind(restInterface, InetSocketAddress.createUnresolved("127.0.0.1",
					// 8080), 1000, null, null, null);
					// 这里启动rest
					// 测试数据时候可以解开标签
					acceptor.tell(new JobRequest(demoData[0].getTime().getValue(), demoData), acceptor);
					
					system.actorOf(Props.create(ClusterDomainEventListener.class), "cluster-listener");
				}
			});
		}
	}

	private static RootData[] prepareData() {
		List<RootData> result = new ArrayList<RootData>(2 << 5);
		for (int i = 0; i < 200000; i++) {
			RootData line1 = new RootData();
			long version = System.currentTimeMillis();
			line1 = line1.initId("key_" + i).initOrgan("sh/xinhua/waike/nima1").initTime(String.valueOf(version))
					.initQueue("catA,ratA,ratB");
			// JSONObject encode = JSONObject.fromObject(line1);
			// System.out.println(encode.toString());
			result.add(line1);
		}
		return result.toArray(new RootData[result.size()]);
	}

}
