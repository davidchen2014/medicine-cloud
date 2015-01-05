package com.wondersgroup.cloud.cluster.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("medicine/service")
public interface MedicineService {

	@POST
	@Path("single")
	public int inputdata(@FormParam("organ") String organ, @FormParam("time") String time,
			@FormParam("queue") String queue);

	@POST
	public int inputdata(@FormParam("size") int size, @FormParam("content")String content);

	@GET
	public int inputdata();
	
	@GET
	public void createTable(@PathParam("tableName") String tableName, @PathParam("columnListArr") String[] columnListArr);
	
//	@PUT
//	public int query(@FormParam("tableName") String tableName);
//	
//	@PUT
//	public int query(@FormParam("tableName") String tableName, @FormParam("rowkey") String rowkey);
}
