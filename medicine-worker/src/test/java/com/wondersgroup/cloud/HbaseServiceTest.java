package com.wondersgroup.cloud;

import java.io.IOException;

import junit.framework.TestCase;

import com.wondersgroup.cloud.medicine.hbase.service.HbaseService;
import com.wondersgroup.cloud.medicine.hbase.service.impl.HbaseServiceImpl;
import com.wondersgroup.cloud.medicine.hbase.util.CommonUtil;

public class HbaseServiceTest extends TestCase{
	HbaseService hbaseService = new HbaseServiceImpl();

	public void testCreateTableTest() {
		String[] cloumnStr = {"hospitalName","DepartmentName","DepartmentChildName","doorNo","time","snapshot","totalInfo"};
		hbaseService.createTable("medicine",cloumnStr);
	}
	
	public void testInsertDataTest() {
		try {
			String cmd = CommonUtil.readDataFromConsole("input cmd:");
			if (null != cmd) {
//				String[] cloumnStr = {"hospitalName","DepartmentName","DepartmentChildName","doorNo","time","snapshot"};
				hbaseService.insertData("medicine");
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
		hbaseService.QueryAll();
	}
	
	/**
	 * 单条件查询,根据rowkey查询唯一一条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition1Test() throws IOException{
		String rowkey = hbaseService.QueryByCondition1("test","key_2");
		System.out.println(rowkey);
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
	
	public void testDropTableTest() {
		hbaseService.dropTable("medicine");
	}
}
