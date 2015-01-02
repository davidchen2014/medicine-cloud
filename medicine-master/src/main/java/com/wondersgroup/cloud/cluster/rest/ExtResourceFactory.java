package com.wondersgroup.cloud.cluster.rest;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResourceFactory;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * We don't support propertyInjector here since the resource impl should be singleton in dubbo
 * 
 */
public class ExtResourceFactory implements ResourceFactory {

	private Object resourceInstance;
	private Class scannableClass;

	// private PropertyInjector propertyInjector;
	// private String context = null;

	public ExtResourceFactory(Object resourceInstance, Class scannableClass) {
		this.resourceInstance = resourceInstance;
		this.scannableClass = scannableClass;
	}

	// public PropertyInjector getPropertyInjector() {
	// return propertyInjector;
	// }

	public Object createResource(HttpRequest request, HttpResponse response, ResteasyProviderFactory factory) {
		return resourceInstance;
	}

	public Class<?> getScannableClass() {
		return scannableClass;
	}

	public void registered(ResteasyProviderFactory factory) {
		// this.propertyInjector = factory.getInjectorFactory().createPropertyInjector(getScannableClass(), factory);
	}

	public void requestFinished(HttpRequest request, HttpResponse response, Object resource) {
	}

	public void unregistered() {
	}

	// public void setContext(String context) {
	// this.context = context;
	// }
	//
	// public String getContext() {
	// return context;
	// }
}