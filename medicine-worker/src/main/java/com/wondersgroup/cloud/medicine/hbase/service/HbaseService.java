package com.wondersgroup.cloud.medicine.hbase.service;

import java.io.IOException;

import com.wondersgroup.cloud.medicine.model.RootData;

public interface HbaseService {
	
	/**
	 * 创建表
	 * 
	 * @param tableName
	 */
	public void createTable(String tableName,String[] columnListArr);
	
	/**
	 * 插入数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void insertData(String tableName) throws IOException;
	
	/**
	 * 插入数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void insertData(String tableName,RootData[] rootData) throws IOException;
	
	/**
	 * 删除一张表
	 * 
	 * @param tableName
	 */
	public void dropTable(String tableName);
	
	/**
	 * 根据 rowkey删除一条记录
	 * 
	 * @param tablename
	 * @param rowkey
	 */
	public void deleteRow(String tablename, String rowkey);
	
	/**
	 * 查询所有数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryAll(String tableName) throws IOException;
	
	/**
	 * 单条件查询,根据rowkey查询唯一一条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition1(String tableName,String rowkey) throws IOException;
	
	/**
	 * 单条件按查询，查询多条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition2(String tableName,String columnName,String columnValue) throws IOException;
	
	/**
	 * 组合条件查询
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition3(String tableName,String[] columnNameArr,String[] cloumnValueArr) throws IOException;
}
