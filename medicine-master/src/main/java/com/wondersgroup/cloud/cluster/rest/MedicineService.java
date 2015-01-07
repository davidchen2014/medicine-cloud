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
	public void inputdata(@FormParam("organ") String organ, @FormParam("time") String time,
			@FormParam("queue") String queue);

	@POST
	public void inputdata(@FormParam("size") int size, @FormParam("content")String content);

	@POST
	@Path("createTable")
	public int createTable(@PathParam("columnStr") String columnStr);
	
	@GET
	public JSONObject QueryByCondition1(@PathParam("rowkey") String rowkey);
	
}
