package com.wondersgroup.cloud.cluster.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class SeedApp {

	private static Log logger = LogFactory.getLog(SeedApp.class);

	public static void main(String[] args) {
		// System.setProperty("PORT", "2551");
		// System.setProperty("HOST", "127.0.0.1");

		final String port = args.length > 0 ? args[1] : "0";
		final String ip = args.length > 0 ? args[0] : "localhost";

		final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.parseString("akka.cluster.roles = [seed]"))
				.withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.hostname=" + ip))
				.withFallback(ConfigFactory.load("seed"));

		// Config config = ConfigFactory.load("seed");
		// logger.info(config.getString("akka.loglevel"));
		ActorSystem system = ActorSystem.create("medicine", config);
		logger.info("Starting node with roles: ${Cluster(" + system + ").selfRoles}");
	}

}
