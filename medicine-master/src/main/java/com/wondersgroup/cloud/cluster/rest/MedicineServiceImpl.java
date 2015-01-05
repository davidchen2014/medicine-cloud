package com.wondersgroup.cloud.cluster.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import net.sf.json.JSONArray;

import akka.actor.ActorRef;

import com.wondersgroup.cloud.medicine.hbase.service.HbaseService;
import com.wondersgroup.cloud.medicine.hbase.service.impl.HbaseServiceImpl;
import com.wondersgroup.cloud.medicine.model.JobRequest;
import com.wondersgroup.cloud.medicine.model.RootData;

@Path("medicine/service")
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
	public int inputdata(@FormParam("organ") String organ, @FormParam("time") String time,
			@FormParam("queue") String queue) {
		RootData line1 = new RootData();
		line1 = line1.initOrgan(organ).initTime(time).initQueue(queue);
		JobRequest job = new JobRequest(time, new RootData[] { line1 });
		jobAcceptor.tell(job, jobAcceptor);
		return Constants.SUCCESS;
	}

	@Override
	@POST
	public int inputdata(@FormParam("size") int size, @FormParam("content") String content) {
		RootData[] datas = (RootData[]) JSONArray.toArray(JSONArray.fromObject(content), RootData.class);
		JobRequest job = new JobRequest(datas[0].getTime().getValue(), datas);
		jobAcceptor.tell(job, jobAcceptor);
		return Constants.SUCCESS;
	}
	
	@Override
	@GET
	public int inputdata(){
		List<RootData> result = new ArrayList<RootData>(2 << 5);
		for (int i = 0; i < 200000; i++) {
			RootData line1 = new RootData();
			long version = System.currentTimeMillis();
			line1 = line1.initId("key_" + i).initOrgan("sh/xinhua/waike/nima1").initTime(String.valueOf(version))
					.initQueue("catA,ratA,ratB");
			// JSONObject encode = JSONObject.fromObject(line1);
			// System.out.println(encode.toString());
			result.add(line1);
		}
		RootData[] datas = result.toArray(new RootData[result.size()]);
		JobRequest job = new JobRequest(datas[0].getTime().getValue(), datas);
		jobAcceptor.tell(job, jobAcceptor);
		return Constants.SUCCESS;
	}
	
	
	@Override
	@GET
	public void createTable(@PathParam("tableName") String tableName, @PathParam("columnListArr") String[] columnListArr){
		hbaseService.createTable(tableName, columnListArr);
	}
	
//	@Override
//	@PUT
//	public int query(@PathParam("tableName") String tableName){
//		try {
//			hbaseService.QueryAll(tableName);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return Constants.SUCCESS;
//	}
//	
//	@Override
//	@PUT
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
