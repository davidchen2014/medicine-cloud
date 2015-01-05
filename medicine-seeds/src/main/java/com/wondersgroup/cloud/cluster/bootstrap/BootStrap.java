package com.wondersgroup.cloud.cluster.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class BootStrap {

	private static Log logger = LogFactory.getLog(BootStrap.class);

	public static void main(String[] args) {
		final String ip = args.length > 0 ? args[0] : "localhost";
		final String port = args.length > 0 ? args[1] : "0";

		final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.parseString("akka.cluster.roles = [master]"))
				.withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.hostname=" + ip))
				.withFallback(ConfigFactory.load("seed"));

		ActorSystem system = ActorSystem.create("medicine", config);
		logger.info("Starting node with roles: ${Cluster(" + system + ").selfRoles}");
	}

}
