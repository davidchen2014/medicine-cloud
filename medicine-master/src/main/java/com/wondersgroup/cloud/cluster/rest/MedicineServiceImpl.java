package com.wondersgroup.cloud.cluster.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import net.sf.json.JSONArray;

import akka.actor.ActorRef;

import com.wondersgroup.cloud.medicine.model.JobRequest;
import com.wondersgroup.cloud.medicine.model.RootData;

@Path("medicine/service")
public class MedicineServiceImpl implements MedicineService {

	private ActorRef jobAcceptor;

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

}
