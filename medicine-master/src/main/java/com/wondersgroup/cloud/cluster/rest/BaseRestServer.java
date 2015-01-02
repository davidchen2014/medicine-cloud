/**
 * 
 */
package com.wondersgroup.cloud.cluster.rest;

import org.jboss.resteasy.spi.ResteasyDeployment;

public abstract class BaseRestServer implements RestServer {

	public void start(int port) {
		getDeployment().getMediaTypeMappings().put("json", "application/json");
		getDeployment().getMediaTypeMappings().put("xml", "text/xml");
		// server.getDeployment().getMediaTypeMappings().put("xml", "application/xml");
		// getDeployment().getProviderClasses().add(RpcContextFilter.class.getName());
		// loadProviders(url.getParameter(Constants.EXTENSION_KEY, ""));
		doStart(port);
	}

	public void deploy(Class resourceDef, Object resourceInstance, String contextPath) {
		if (null == contextPath || "".equals(contextPath)) {
			getDeployment().getRegistry().addResourceFactory(new ExtResourceFactory(resourceInstance, resourceDef));
		} else {
			getDeployment().getRegistry().addResourceFactory(new ExtResourceFactory(resourceInstance, resourceDef),
					contextPath);
		}
	}

	public void undeploy(Class resourceDef) {
		getDeployment().getRegistry().removeRegistrations(resourceDef);
	}

	// protected void loadProviders(String value) {
	// for (String clazz : Constants.COMMA_SPLIT_PATTERN.split(value)) {
	// if (!StringUtils.isEmpty(clazz)) {
	// getDeployment().getProviderClasses().add(clazz.trim());
	// }
	// }
	// }

	protected abstract ResteasyDeployment getDeployment();

	protected abstract void doStart(int port);
}
