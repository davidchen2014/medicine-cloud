package com.wondersgroup.cloud.demo.cluster;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Main {

	private static Log logger = LogFactory.getLog(Main.class);

	public static void main(String[] args) {
		Config config = ConfigFactory.load();
		logger.info(config.getString("akka.aa"));
		ActorSystem system = ActorSystem.create("medicine", config);
		logger.info("Starting node with roles: ${Cluster(" + system + ").selfRoles}");
	}

}
