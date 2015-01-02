package com.wondersgroup.cloud.cluster.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("sample/demo2")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class Demo2ServiceImpl implements Demo2Service {

	@GET
	@Path("{firstName}")
	public String sayHello(@PathParam("firstName") String firstName) {
		return firstName + "!!";
	}

}
