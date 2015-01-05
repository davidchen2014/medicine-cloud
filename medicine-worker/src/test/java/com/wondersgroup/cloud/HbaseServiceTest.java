package com.wondersgroup.cloud;

import java.io.IOException;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import junit.framework.TestCase;

import com.wondersgroup.cloud.medicine.hbase.service.HbaseService;
import com.wondersgroup.cloud.medicine.hbase.service.impl.HbaseServiceImpl;
import com.wondersgroup.cloud.medicine.hbase.util.CommonUtil;

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
//				String[] cloumnStr = {"hospitalName","DepartmentName","DepartmentChildName","doorNo","time","snapshot"};
				hbaseService.insertData("test");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryAllTest() throws IOException {
		hbaseService.QueryAll("test");
	}
	
	/**
	 * 单条件查询,根据rowkey查询唯一一条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition1Test() throws IOException{
		hbaseService.QueryByCondition1("test","key_2");
	}
	
	/**
	 * 单条件按查询，查询多条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition2Test() throws IOException{
		hbaseService.QueryByCondition2("test","DepartmentChildName","waike");
	}
	
	/**
	 * 组合条件查询
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition3Test() throws IOException{
		String[] columnNameArr = {"DepartmentChildName","DepartmentName"};
		String[] columnValueArr = {"waike","xinhua"};
		hbaseService.QueryByCondition3("test",columnNameArr,columnValueArr);
	}
	
	public void dropTableTest() {
		hbaseService.dropTable("test");
	}
}
