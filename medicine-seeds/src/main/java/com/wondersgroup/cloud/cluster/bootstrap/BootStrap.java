package com.wondersgroup.cloud.cluster.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class BootStrap {

	private static Log logger = LogFactory.getLog(BootStrap.class);

	public static void main(String[] args) {
		// System.setProperty("PORT", "2551");
		// System.setProperty("HOST", "127.0.0.1");
		Config config = ConfigFactory.load("seed");
		logger.info(config.getString("akka.loglevel"));
		ActorSystem system = ActorSystem.create("medicine", config);
		logger.info("Starting node with roles: ${Cluster(" + system + ").selfRoles}");
	}

}
