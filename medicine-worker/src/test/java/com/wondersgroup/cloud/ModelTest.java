package com.wondersgroup.cloud;

import com.wondersgroup.cloud.hbase.model.RootData;

import net.sf.json.JSONObject;
import junit.framework.TestCase;

public class ModelTest extends TestCase {
	public void testModel() {
		long version = System.currentTimeMillis();
		RootData line1 = new RootData();
		line1 = line1.initOrgan("sh/xinhua/waike/nima1").initTime(version).initQueue("catA,ratA,ratB");
		JSONObject encode = JSONObject.fromObject(line1);
		System.out.println(encode.toString());

		RootData decode = (RootData) JSONObject.toBean(encode, RootData.class);
		assertTrue(decode.getOrgan().getPath() == line1.getOrgan().getPath());
	}
}
