package com.wondersgroup.cloud.cluster.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.wondersgroup.cloud.medicine.model.RootData;

public class RestNettyServerTest extends TestCase {

	private Log logger = LogFactory.getLog(RestNettyServerTest.class);

	private RestServer server;

	@Override
	protected void setUp() throws Exception {

	}

	@Override
	protected void tearDown() throws Exception {
//		server.stop();
//		logger.info("server stop");
	}

	public void testDeployInstance() {
		server = new NettyServer();
		server.start(8080);
		logger.info("server start at 8080");

		Demo2Service service = new Demo2ServiceImpl();
		server.deploy(Demo2ServiceImpl.class, service, "");
		logger.info("server deploy service successful");
		// server.undeploy(Demo2ServiceImpl.class);

		while (true) {

		}

		// call like this pattern: http://localhost:8080/sample/demo2/dabian
	}

	public void testCallRest() throws ClientProtocolException, IOException {
		String url = "http://10.1.65.104:8090/medicine/service";
		// POST的URL
		HttpPost httppost = null;// new HttpPost(url);
		// 建立HttpPost对象
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		long startTime = System.currentTimeMillis();
		
		for(int k=4540; k<4740; k++){
			RootData[] datas = prepareData(k);
			params.clear();
			params.add(new BasicNameValuePair("size", String.valueOf(datas.length)));
			params.add(new BasicNameValuePair("content", JSONArray.fromObject(datas).toString()));
			// 添加参数
			httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			// 设置编码
			HttpResponse response = new DefaultHttpClient().execute(httppost);
			
		}
		
		long endTime = System.currentTimeMillis();
		logger.info("total time:"+(endTime-startTime)+" ms");
//		assertTrue(response.getStatusLine().getStatusCode() == 204);
	}

	private static RootData[] prepareData(int k) {
		List<RootData> result = new ArrayList<RootData>(2 << 5);
		for (int i = 0; i < 1000; i++) {
			RootData line1 = new RootData();
			long version = System.currentTimeMillis();
			line1 = line1.initId("keys_"+k+"_" + i).initOrgan("sh/xinhua/waike/nima1").initTime(String.valueOf(version))
					.initQueue("catA,ratA,ratB,ratA,ratB,ratA,ratB,ratA,ratB,ratA,ratB,ratA,ratB");
			// JSONObject encode = JSONObject.fromObject(line1);
			// System.out.println(encode.toString());
			result.add(line1);
		}
		return result.toArray(new RootData[result.size()]);
	}

	public void testArray() {
		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int length = 4;
		int start = 0;
		int end = start + length;
		int total = arrays.length;

		while (start <= total) {
			if (end > total)
				end = total;
			int[] parts = Arrays.copyOfRange(arrays, start, end);
			logger.info("parts::" + JSONArray.fromObject(parts).toString());
			start = end + 1;
			end = start + length;
		}
	}
}
