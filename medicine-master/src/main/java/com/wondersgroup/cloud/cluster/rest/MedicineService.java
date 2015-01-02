package com.wondersgroup.cloud.cluster.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("medicine/service")
public interface MedicineService {

	@POST
	@Path("single")
	public int inputdata(@FormParam("organ") String organ, @FormParam("time") String time,
			@FormParam("queue") String queue);

	@POST
	public int inputdata(@FormParam("size") int size, @FormParam("content")String content);

}
