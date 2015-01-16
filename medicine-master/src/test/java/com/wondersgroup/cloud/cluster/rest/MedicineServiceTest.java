package com.wondersgroup.cloud.cluster.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.wondersgroup.cloud.medicine.model.RootData;

import junit.framework.Test;
import junit.framework.TestCase;

public class MedicineServiceTest extends TestCase {
	private Log logger = LogFactory.getLog(RestNettyServerTest.class);
	
	public void inputdataTest() throws ClientProtocolException, IOException{
		String url = "http://10.141.222.246:8080/medicine/service";
		// POST的URL
		HttpPost httppost = new HttpPost(url);
		// 建立HttpPost对象
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		RootData[] datas = prepareData();
		params.add(new BasicNameValuePair("size", String.valueOf(datas.length)));
		params.add(new BasicNameValuePair("content", JSONArray.fromObject(datas).toString()));
		// 添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		// 设置编码
		HttpResponse response = new DefaultHttpClient().execute(httppost);
		assertTrue(response.getStatusLine().getStatusCode() == Constants.SUCCESS);
	}
	
	
	public void createTableTest() throws ClientProtocolException, IOException{
		String cloumnStr= "hospitalName,DepartmentName,DepartmentChildName,doorNo,time,snapshot,totalInfo";
		String url = "http://127.0.0.1:8080/medicine/service/createTable";
		// POST的URL
		HttpPost httppost = new HttpPost(url);
		// 建立HttpPost对象
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		params.add(new BasicNameValuePair("tableName", "table1"));
		params.add(new BasicNameValuePair("columnStr", cloumnStr));
		// 添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		// 设置编码
		HttpResponse response = new DefaultHttpClient().execute(httppost);
		assertTrue(response.getStatusLine().getStatusCode() == Constants.SUCCESS);
		
	}
	
	public void queryAllTest() throws ClientProtocolException, IOException{

		String url = "http://127.0.0.1:8080/medicine/service/queryAll";
		// POST的URL
		HttpPost httppost = new HttpPost(url);
		// 建立HttpPost对象
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 建立一个NameValuePair数组，用于存储欲传送的参数
		params.add(new BasicNameValuePair("tableName", "test"));
		// 添加参数
		httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		// 设置编码
		HttpResponse response = new DefaultHttpClient().execute(httppost);
		assertTrue(response.getStatusLine().getStatusCode() == Constants.SUCCESS);
		
	}
	
	public void QueryByCondition1Test() throws ClientProtocolException, IOException{

		String url = "http://127.0.0.1:8080/medicine/service/key_1";
		// POST的URL
		HttpGet httpGet = new HttpGet(url);
		// 设置编码
		HttpResponse response = new DefaultHttpClient().execute(httpGet);
		assertTrue(response.getStatusLine().getStatusCode() == Constants.SUCCESS);
		
	}
	
	public void testJson(){
		long version = System.currentTimeMillis();
		RootData line1 = new RootData();
		line1 = line1.initId("key_1").initOrgan("sh/xinhua/waike/nima1").initTime(String.valueOf(version))
				.initQueue("catA,ratA,ratB");
		System.out.println(JSONObject.fromObject(line1).toString());
	}
	

	private static RootData[] prepareData() {
		List<RootData> result = new ArrayList<RootData>(2 << 5);
		for (int i = 0; i < 20000; i++) {
			RootData line1 = new RootData();
			long version = System.currentTimeMillis();
			line1 = line1.initId("key_2_"+i).initOrgan("sh/xinhua/waike/nima1").initTime(String.valueOf(version))
					.initQueue("catA,ratA,ratB");
			// JSONObject encode = JSONObject.fromObject(line1);
			// System.out.println(encode.toString());
			result.add(line1);
		}
		return result.toArray(new RootData[result.size()]);
	}
}
