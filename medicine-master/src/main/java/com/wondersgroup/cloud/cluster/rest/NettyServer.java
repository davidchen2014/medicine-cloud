/**
 *
 */
package com.wondersgroup.cloud.cluster.rest;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

/**
 * Netty server can't support @Context injection of servlet objects since it's not a servlet container
 * 
 */
public class NettyServer extends BaseRestServer {

	private final NettyJaxrsServer server = new NettyJaxrsServer();

	protected void doStart(int port) {
		server.setPort(port);
		server.setKeepAlive(true);
		server.setExecutorThreadCount(200);
		server.setIoWorkerCount(Runtime.getRuntime().availableProcessors() + 1);
		server.start();
	}

	public void stop() {
		server.stop();
	}

	protected ResteasyDeployment getDeployment() {
		return server.getDeployment();
	}
}
