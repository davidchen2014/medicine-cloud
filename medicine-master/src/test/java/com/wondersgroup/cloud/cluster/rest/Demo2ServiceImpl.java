package com.wondersgroup.cloud.cluster.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wondersgroup.cloud.medicine.model.RootData;

@Path("sample/demo2")
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class Demo2ServiceImpl implements Demo2Service {

	private Log logger = LogFactory.getLog(Demo2ServiceImpl.class);

	@GET
	@Path("{firstName}")
	public String sayHello(@PathParam("firstName") String firstName) {
		return firstName + "!!";
	}

	@POST
	public int inputdata(@FormParam("size") int size, @FormParam("content") String content) {
		RootData[] datas = (RootData[]) JSONArray.toArray(JSONArray.fromObject(content), RootData.class);
		logger.info("data size:::" + datas.length);
		return Constants.SUCCESS;
	}
}
