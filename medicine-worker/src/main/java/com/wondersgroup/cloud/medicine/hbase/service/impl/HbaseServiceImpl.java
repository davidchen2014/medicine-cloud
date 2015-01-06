package com.wondersgroup.cloud.medicine.hbase.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import com.wondersgroup.cloud.medicine.hbase.service.HbaseService;
import com.wondersgroup.cloud.medicine.model.RootData;

public class HbaseServiceImpl implements HbaseService{

	private static Configuration hbaseConfig = null;
	
	// public static HBaseAdmin hBaseAdmin = null;
	static {
		// configuration = HBaseConfiguration.create();
		// Configuration config = new Configuration();
		// config.addResource("hbase-site.xml");
		// configuration.set("hbase.master", "10.1.64.69:600000");
		
		// config.set("hbase.zookeeper.quorum", "bd-08,bd-09,bd-10");
		// config.set("hbase.zookeeper.property.clientPort", "2181");
		hbaseConfig = HBaseConfiguration.create();
	}

	private static String readDataFromConsole(String prompt) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			System.out.print(prompt);
			str = br.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static void main(String[] args) {
//		 createTable("wujintao");
//		try {
////			String cmd = readDataFromConsole("input cmd:");
////			if (null != cmd) {
//				//insertData("wujintao");
////			}
//			// QueryAll("wujintao");
//			// QueryByCondition1("wujintao");
//			// QueryByCondition2("wujintao");
//			// QueryByCondition3("wujintao");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// deleteRow("wujintao","112233bbbcccc");
//		 dropTable("wujintao");
	}

//	public static void init() throws HBaseException {
//		try {
//			// hBaseAdmin = new HBaseAdmin(hbaseConfig);
//		} catch (Exception e) {
//			throw new HBaseException(e);
//		}
//	}

	/**
	 * 创建表
	 * 
	 * @param tableName
	 */
	public void createTable(String tableName,String[] columnListArr) {
		System.out.println("start create table ......");
		try {
			HBaseAdmin hBaseAdmin = new HBaseAdmin(hbaseConfig);
			if (hBaseAdmin.tableExists(tableName)) {// 如果存在要创建的表，那么先删除，再创建
				hBaseAdmin.disableTable(tableName);
				hBaseAdmin.deleteTable(tableName);
				System.out.println(tableName + " is exist,detele....");
			}
			HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
			for (int i = 0; i < columnListArr.length; i++) {
				tableDescriptor.addFamily(new HColumnDescriptor(columnListArr[i]));
			}
			hBaseAdmin.createTable(tableDescriptor);
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end create table ......");
	}

	
	/**
	 * 插入数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void insertData(String tableName) throws IOException {
		long start = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(start);
		HTablePool pool = new HTablePool(hbaseConfig, 1000);
		HTableInterface table = pool.getTable(tableName);
		// HConnection connection =
		// HConnectionManager.createConnection(hbaseConfig);
		// HTableInterface table = connection.getTable(tableName);
		System.out.println(formatter.format(date) + " start insert data ......");

		String startTime = formatter.format(date);
		// FileReader reader = new FileReader("d://upload.txt");
		// BufferedReader br = new BufferedReader(reader);
		// String str = null;
		List puts = new ArrayList();
		
		RootData line1 = new RootData();
		line1 = line1.initOrgan("瑞金医院/内科/消化科/202").initTime(startTime).initQueue("catA,ratA,ratB");
		JSONObject jsonObject = JSONObject.fromObject(line1);

		RootData rootData = (RootData) JSONObject.toBean(jsonObject, RootData.class);
		
		// while((str = br.readLine()) != null) {
		for (int i = 1; i <= 200001; i++) {
			Put put = new Put(("key_" + i).getBytes());// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
			put.add("hospitalName".getBytes(), null, (rootData.getOrgan().getPath().split("/")[0]).getBytes());// 本行数据的第一列
			put.add("DepartmentName".getBytes(), null, (rootData.getOrgan().getPath().split("/")[1]).getBytes());// 本行数据的第三列
			put.add("DepartmentChildName".getBytes(), null, (rootData.getOrgan().getPath().split("/")[2]).getBytes());// 本行数据的第三列
			put.add("doorNo".getBytes(), null, (rootData.getOrgan().getPath().split("/")[3]).getBytes());// 本行数据的第三列
			put.add("time".getBytes(), null, startTime.getBytes());// 本行数据的第三列
			put.add("snapshot".getBytes(), null, rootData.getQueue().getValue().getBytes());// 本行数据的第三列
			// table.put(put);

			puts.add(put);
			// System.out.println(str);
			 if(i%100000 == 0 ){
				 table.put(puts);
				 puts.clear();
			 }
		}
		// }
//		table.put(puts);
		// for(int i=0; i<=1000; i++){
		// String key = "key_"+i;
		// String val1 = "val1_"+i;
		// String val2 = "val2_"+i;
		// String val3 = "val3_"+i;
		// Put put = new Put(key.getBytes());//
		// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
		// put.add("column1".getBytes(), null, val1.getBytes());// 本行数据的第一列
		// put.add("column2".getBytes(), null, val2.getBytes());// 本行数据的第三列
		// put.add("column3".getBytes(), null, val3.getBytes());// 本行数据的第三列
		// try {
		// table.put(put);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// }
		long end = System.currentTimeMillis();
		long total_time = end - start;
		Date date1 = new Date(end);
		System.out.println(formatter.format(date1) + " end insert data ......");
		System.out.println("Total time : " + total_time + " ms");
	}

	/**
	 * 插入数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void insertData(String tableName,RootData[] rootData) throws IOException{

		long start = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(start);
		HTablePool pool = new HTablePool(hbaseConfig, 1000);
		HTableInterface table = pool.getTable(tableName);
		System.out.println(formatter.format(date) + " start insert data ......");

		String startTime = formatter.format(date);
		List puts = new ArrayList();
		
		for (int i = 0; i < rootData.length; i++) {
			Put put = new Put(rootData[i].getId().getBytes());// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
			put.add("hospitalName".getBytes(), null, (rootData[i].getOrgan().getPath().split("/")[0]).getBytes());// 本行数据的第一列
			put.add("DepartmentName".getBytes(), null, (rootData[i].getOrgan().getPath().split("/")[1]).getBytes());// 本行数据的第三列
			put.add("DepartmentChildName".getBytes(), null, (rootData[i].getOrgan().getPath().split("/")[2]).getBytes());// 本行数据的第三列
			put.add("doorNo".getBytes(), null, (rootData[i].getOrgan().getPath().split("/")[3]).getBytes());// 本行数据的第三列
			put.add("time".getBytes(), null, startTime.getBytes());// 本行数据的第三列
			put.add("snapshot".getBytes(), null, rootData[i].getQueue().getValue().getBytes());// 本行数据的第三列
			put.add("totalInfo".getBytes(), null, (JSONObject.fromObject(rootData[i]).toString()).getBytes());// 本行数据的第三列
			// table.put(put);
			puts.add(put);
		}
		
		table.put(puts);
		long end = System.currentTimeMillis();
		long total_time = end - start;
		Date date1 = new Date(end);
		System.out.println(formatter.format(date1) + " end insert data ......");
		System.out.println("Total time : " + total_time + " ms");
	
	}
	
	/**
	 * 删除一张表
	 * 
	 * @param tableName
	 */
	public void dropTable(String tableName) {
		try {
			HBaseAdmin admin = new HBaseAdmin(hbaseConfig);
			admin.disableTable(tableName);
			admin.deleteTable(tableName);
			System.out.println("delete table success");
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 根据 rowkey删除一条记录
	 * 
	 * @param tablename
	 * @param rowkey
	 */
	public void deleteRow(String tablename, String rowkey) {
		try {
			HTable table = new HTable(hbaseConfig, tablename);
			List list = new ArrayList();
			Delete d1 = new Delete(rowkey.getBytes());
			list.add(d1);

			table.delete(list);
			System.out.println("删除行成功!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有数据
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryAll() throws IOException {
		HConnection connection = HConnectionManager
				.createConnection(hbaseConfig);
		HTableInterface table = connection.getTable("test");
		try {
			ResultScanner rs = table.getScanner(new Scan());
			for (Result r : rs) {
				System.out.println("获得到rowkey:" + new String(r.getRow()));
				for (KeyValue keyValue : r.raw()) {
					System.out.println("列：" + new String(keyValue.getFamily())
							+ "====值:" + new String(keyValue.getValue()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 单条件查询,根据rowkey查询唯一一条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public String QueryByCondition1(String tableName,String rowkey) throws IOException {

		HConnection connection = HConnectionManager
				.createConnection(hbaseConfig);
		HTableInterface table = connection.getTable("medicine");
		Get scan = new Get(rowkey.getBytes());// 根据rowkey查询
		Result r = table.get(scan);
//		RootData rootData = new RootData();
//		System.out.println("获得到rowkey:" + new String(r.getRow()));
		String rowInfo = "";
		for (KeyValue keyValue : r.raw()) {
//			System.out.println("列：" + new String(keyValue.getFamily())
//					+ "====值:" + new String(keyValue.getValue()));
			if((new String(keyValue.getFamily())).equals("totalInfo")){
				rowInfo = new String(keyValue.getValue());
			}
			
		}
//		System.out.println(rowInfo);
		System.out.println("query data end");
		return rowInfo;
	}

	/**
	 * 单条件按查询，查询多条记录
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition2(String tableName,String columnName,String columnValue) throws IOException {

		HConnection connection = HConnectionManager
				.createConnection(hbaseConfig);
		HTableInterface table = connection.getTable(tableName);
		Filter filter = new SingleColumnValueFilter(Bytes.toBytes("DepartmentChildName"),
				null, CompareOp.EQUAL, Bytes.toBytes("waike")); // 当列column1的值为aaa时进行查询
		Scan s = new Scan();
		s.setFilter(filter);
		ResultScanner rs = table.getScanner(s);
		for (Result r : rs) {
			System.out.println("获得到rowkey:" + new String(r.getRow()));
			for (KeyValue keyValue : r.raw()) {
				System.out.println("列：" + new String(keyValue.getFamily())
						+ "====值:" + new String(keyValue.getValue()));
			}
		}
		rs.close();
		System.out.println("query data end");
	}

	/**
	 * 组合条件查询
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void QueryByCondition3(String tableName,String[] columnNameArr,String[] cloumnValueArr) throws IOException {

		HConnection connection = HConnectionManager
				.createConnection(hbaseConfig);
		HTableInterface table = connection.getTable(tableName);

		List<Filter> filters = new ArrayList<Filter>();

		for(int i=0; i<columnNameArr.length; i++){
			Filter filter = new SingleColumnValueFilter(Bytes.toBytes(columnNameArr[i]),
					null, CompareOp.EQUAL, Bytes.toBytes(cloumnValueArr[i]));
			filters.add(filter);
			
		}

		FilterList filterList = new FilterList(filters);

		Scan scan = new Scan();
		scan.setFilter(filterList);
		ResultScanner rs = table.getScanner(scan);
		for (Result r : rs) {
			System.out.println("获得到rowkey:" + new String(r.getRow()));
			for (KeyValue keyValue : r.raw()) {
				System.out.println("列：" + new String(keyValue.getFamily())
						+ "====值:" + new String(keyValue.getValue()));
			}
		}
		rs.close();
		System.out.println("query data end");

	}

}
