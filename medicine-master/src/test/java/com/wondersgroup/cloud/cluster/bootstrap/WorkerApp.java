package com.wondersgroup.cloud.cluster.bootstrap;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.wondersgroup.cloud.cluster.actor.JobWorker;

public class WorkerApp {

	private static Log logger = LogFactory.getLog(WorkerApp.class);

	public static void main(String[] args) {
		final String port = args.length > 0 ? args[1] : "0";
		final String ip = args.length > 0 ? args[0] : "localhost";

		final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.parseString("akka.cluster.roles = [worker]"))
				.withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.hostname=" + ip))
				.withFallback(ConfigFactory.load("worker"));

		final ActorSystem system = ActorSystem.create("medicine", config);
		logger.info("worker node start");
		// 先手工启动 ，后面再琢磨下 自动发现自动远程启动功能
		system.actorOf(Props.create(JobWorker.class), "jobWorker");
	}
}
