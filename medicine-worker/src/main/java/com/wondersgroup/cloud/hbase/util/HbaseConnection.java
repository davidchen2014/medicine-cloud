package com.wondersgroup.cloud.hbase.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class HbaseConnection {
	private static Configuration hbaseConfig = null;
	// public static HBaseAdmin hBaseAdmin = null;
	static {
		// configuration = HBaseConfiguration.create();
		// Configuration config = new Configuration();
		// config.addResource("hbase-site.xml");
		// // configuration.set("hbase.master", "10.1.64.69:600000");
		// config.set("hbase.zookeeper.quorum", "bd-08,bd-09,bd-10");
		// config.set("hbase.zookeeper.property.clientPort", "2181");
		hbaseConfig = HBaseConfiguration.create();
	}
}
