package com.wondersgroup.cloud.cluster.rest;

import java.util.ArrayList;
import java.util.Arrays;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

public class RestNettyServerTest extends TestCase {

	private Log logger = LogFactory.getLog(RestNettyServerTest.class);

	private RestServer server;

	@Override
	protected void setUp() throws Exception {
		server = new NettyServer();
		server.start(8080);
		logger.info("server start at 8080");
	}

	@Override
	protected void tearDown() throws Exception {
		server.stop();
		logger.info("server stop");
	}

	public void testDeployInstance() {
		Demo2Service service = new Demo2ServiceImpl();
		server.deploy(Demo2ServiceImpl.class, service, "");
		logger.info("server deploy service successful");
		// call like this pattern: http://localhost:8080/sample/demo2/dabian
		server.undeploy(Demo2ServiceImpl.class);
	}

	public void testArray() {
		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int length = 4;
		int start = 0;
		int end = start + length;
		int total = arrays.length;

		while (start <= total) {
			if (end > total) end = total;
			int[] parts = Arrays.copyOfRange(arrays, start, end);
			logger.info("parts::" + JSONArray.fromObject(parts).toString());
			start = end + 1;
			end = start + length;
		}
	}
}
