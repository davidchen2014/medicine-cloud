package com.wondersgroup.cloud.cluster.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import net.sf.json.JSONObject;

import com.wondersgroup.cloud.medicine.model.RootData;

@Path("medicine/service")
public interface MedicineService {

	@POST
	@Path("single")
	public int inputdata(@FormParam("organ") String organ, @FormParam("time") String time,
			@FormParam("queue") String queue);

	@POST
	public int inputdata(@FormParam("size") int size, @FormParam("content")String content);

//	@POST
//	@Path("createTable")
//	public int createTable(@PathParam("tableName") String tableName, @PathParam("columnStr") String columnStr);
	
//	@GET
//	//@Path("queryAll")
//	public int queryAll();
	
	@GET
	public JSONObject QueryByCondition1(@PathParam("rowkey") String rowkey);
	
//	@GET
//	public int query(@FormParam("tableName") String tableName, @FormParam("rowkey") String rowkey);
}
