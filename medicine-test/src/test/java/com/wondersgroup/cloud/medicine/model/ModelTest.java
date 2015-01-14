package com.wondersgroup.cloud.medicine.model;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import com.wondersgroup.cloud.medicine.model.RootData;

import net.sf.json.JSONObject;
import junit.framework.TestCase;

public class ModelTest extends TestCase {
	public void testModel() {
		long version = System.currentTimeMillis();
		RootData line1 = new RootData();
		line1 = line1.initOrgan("sh/xinhua/waike/nima1").initTime(String.valueOf(version)).initQueue("catA,ratA,ratB");

		JSONObject encode = JSONObject.fromObject(line1);
		System.out.println(encode.toString());

		RootData decode = (RootData) JSONObject.toBean(encode, RootData.class);
		assertTrue(decode.getOrgan().getPath() == line1.getOrgan().getPath());
	}

	public void testTime() {
		// 这个走系统时间的
		System.currentTimeMillis();
		// 这个走的是jvm时间
		// This method can only be used to measure elapsed time and is not related to any other notion of system or
		// wall-clock time.
		// System.nanoTime();

		// LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(10*1000));
	}

	public void testString() {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		// 为啥！！ 狗屁啊 居然说java词在系统之前已经存在过了！
		String str2 = new StringBuilder("ja").append("va").toString();
		// 按照之前的理解 两个对象了 肯定不一致 == 不成立
		// 1.7 的情况说是intern放到堆上面去了，这个是..........
		// 找到一段话：
		// 为什么JRockit与新的JDK7里的HotSpot会返回true其实很简单：它们的string
		// pool并不拷贝输进来intern()的java.lang.String实例，
		// 只是在池里记录了每组内容相同的String实例首个被intern的那个实例的引用。
		// 这就好解释了，如果是引用
		// 感觉是比 == "常量" 多加了一层 如果是 首个创建对象 也能等于了
		System.out.println(str2.intern() == str2);
	}
}
