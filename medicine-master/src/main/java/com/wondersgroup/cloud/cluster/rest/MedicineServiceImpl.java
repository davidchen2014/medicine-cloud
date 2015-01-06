package com.wondersgroup.cloud.cluster.rest;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import akka.actor.ActorRef;

import com.wondersgroup.cloud.medicine.hbase.service.HbaseService;
import com.wondersgroup.cloud.medicine.hbase.service.impl.HbaseServiceImpl;
import com.wondersgroup.cloud.medicine.model.JobRequest;
import com.wondersgroup.cloud.medicine.model.RootData;

@Path("medicine/service")
@Produces({MediaType.APPLICATION_JSON})
public class MedicineServiceImpl implements MedicineService {

	private ActorRef jobAcceptor;

	private HbaseService hbaseService = new HbaseServiceImpl();
	
	public MedicineServiceImpl(ActorRef jobAcceptor) {
		// 后面可以改成用lookup方式去定位集群上面的jobAcceptor(master)节点
		this.jobAcceptor = jobAcceptor;
	}

	@Override
	@POST
	@Path("single")
	public void inputdata(@FormParam("organ") String organ, @FormParam("time") String time,
			@FormParam("queue") String queue) {
		RootData line1 = new RootData();
		line1 = line1.initOrgan(organ).initTime(time).initQueue(queue);
		JobRequest job = new JobRequest(time, new RootData[] { line1 });
		jobAcceptor.tell(job, jobAcceptor);
	}

	@Override
	@POST
	public void inputdata(@FormParam("size") int size, @FormParam("content") String content) {
		RootData[] datas = (RootData[]) JSONArray.toArray(JSONArray.fromObject(content), RootData.class);
		JobRequest job = new JobRequest(datas[0].getTime().getValue(), datas);
		jobAcceptor.tell(job, jobAcceptor);
	}
	
//	@Override
//	@POST
//	@Path("createTable")
//	public int createTable(@FormParam("tableName") String tableName, @FormParam("columnStr") String columnStr){
//		String[] columnArr = columnStr.split(",");
//		hbaseService.createTable(tableName, columnArr);
//		return Constants.SUCCESS;
//	}
	
//	@Override
//	@GET
//	//@Path("queryAll")
//	public int queryAll(){
//		try {
//			hbaseService.QueryAll();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Constants.SUCCESS;
//	}
	
	@Override
	@GET
	@Path("{rowkey}")
	public JSONObject QueryByCondition1(@PathParam("rowkey") String rowkey){
		String rowInfo = "";
		try {
			rowInfo = hbaseService.QueryByCondition1("test", rowkey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return JSONObject.fromObject(rowInfo);
	}
//	
//	@Override
//	@POST
//	@Path("query")
//	public int query(@FormParam("tableName") String tableName, @FormParam("rowkey") String rowkey){
//		try {
//			hbaseService.QueryByCondition1(tableName, rowkey);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Constants.SUCCESS;
//	}
}
