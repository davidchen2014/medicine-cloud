/**
 *
 */
package com.wondersgroup.cloud.cluster.rest;


/**
 */
public interface RestServer {

	void start(int port);

	/**
	 * @param resourceDef
	 *            it could be either resource interface or resource impl
	 */
	void deploy(Class resourceDef, Object resourceInstance, String contextPath);

	void undeploy(Class resourceDef);

	void stop();
}
