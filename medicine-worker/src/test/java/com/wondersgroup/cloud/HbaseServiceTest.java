package com.wondersgroup.cloud;

import java.io.IOException;

import junit.framework.TestCase;

import com.wondersgroup.cloud.hbase.service.HbaseService;
import com.wondersgroup.cloud.hbase.service.impl.HbaseServiceImpl;
import com.wondersgroup.cloud.hbase.util.CommonUtil;

public class HbaseServiceTest extends TestCase{
	HbaseService hbaseService = new HbaseServiceImpl();

	public void createTableTest() {
		String[] cloumnStr = {"hospitalName","DepartmentName","DepartmentChildName","doorNo","time","snapshot"};
		hbaseService.createTable("test",cloumnStr);
	}
	
	public void insertDataTest() {
		try {
			String cmd = CommonUtil.readDataFromConsole("input cmd:");
			if (null != cmd) {
				hbaseService.insertData("test");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dropTableTest() {
		hbaseService.dropTable("test");
	}
}
