package com.wondersgroup.cloud.cluster.actor;

import java.util.Arrays;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.cluster.routing.ClusterRouterPool;
import akka.cluster.routing.ClusterRouterPoolSettings;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.BroadcastPool;

import com.wondersgroup.cloud.cluster.rest.MedicineService;
import com.wondersgroup.cloud.cluster.rest.MedicineServiceImpl;
import com.wondersgroup.cloud.cluster.rest.NettyServer;
import com.wondersgroup.cloud.cluster.rest.RestServer;
import com.wondersgroup.cloud.medicine.model.JobRequest;
import com.wondersgroup.cloud.medicine.model.RootData;

/*
 * 可以接受多个任务，然后下发给不同的master节点进行处理
 * */
public class JobAcceptor extends UntypedActor {

	private RestServer server;

	private int totalInstances = 100;
	private int maxInstancesPerNode = 1;
	private boolean allowLocalRoutees = false;// 本地测试可以用true
	private String useRole = "worker";
	private LoggingAdapter logger = Logging.getLogger(super.getContext().system(), this);

	// 配置文件
	// private ActorRef worker = getContext().actorOf(FromConfig.getInstance().props(), "workerRouter");

	// 纯代码配置
	private ActorRef workerRouter = getContext().actorOf(
			new ClusterRouterPool(new BroadcastPool(10), new ClusterRouterPoolSettings(totalInstances,
					maxInstancesPerNode, allowLocalRoutees, useRole)).props(Props.create(JobWorker.class)),
			"workerRouter1");

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return SupervisorStrategy.stoppingStrategy();
	}

	@Override
	public void onReceive(Object message) throws Exception {
		logger.info("message---" + message);
		if (message instanceof JobRequest) {
			JobRequest content = (JobRequest) message;
			logger.info("root_path:::" + workerRouter.path().toString());

			RootData[] datas = content.getData();
			int length = 2000;
			int start = 0;
			int end = start + length;
			int total = datas.length;

			while (start < total) {
				if (end > total)
					end = total;
				RootData[] parts = Arrays.copyOfRange(datas, start, end);
				logger.info("准备发送数据给worker::数量" + parts.length);
				workerRouter.tell(new JobRequest(parts[0].getTime().getValue(), parts), super.getSelf());
				start = end;
				end = start + length;
			}

			// workerRouter.tell("Dabian222!!!! ", super.getSelf());
			// logger.info("content：：：" + content.getValue());
			// ActorRef masterRef = getContext().actorOf(Props.create(JobMaster.class), "job-" + content.getId());
			// masterRef.tell(content, super.getSelf());
		}
	}

	@Override
	public void postStop() throws Exception {
		server.stop();
	}

	@Override
	public void preStart() throws Exception {
		server = new NettyServer();
		server.start(8090);
		MedicineService service = new MedicineServiceImpl(this.getSelf());
		server.deploy(MedicineServiceImpl.class, service, "");
	}

}
