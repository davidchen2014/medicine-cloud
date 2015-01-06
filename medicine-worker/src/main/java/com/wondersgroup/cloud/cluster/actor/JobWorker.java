package com.wondersgroup.cloud.cluster.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import com.wondersgroup.cloud.medicine.hbase.service.HbaseService;
import com.wondersgroup.cloud.medicine.hbase.service.impl.HbaseServiceImpl;
import com.wondersgroup.cloud.medicine.model.JobRequest;

public class JobWorker extends UntypedActor {

	private LoggingAdapter logger = Logging.getLogger(super.getContext().system(), this);

	@Override
	public void onReceive(Object message) throws Exception {
		logger.info("remote worker receiveMessage:---" + message);
		if (message instanceof JobRequest) {
			// todo通过spring extension注入获得service
			JobRequest request = (JobRequest) message;
			HbaseService hbaseService = new HbaseServiceImpl();
			hbaseService.insertData("medicine", request.getData());
			logger.info("remote worker receiveMessage:---" + request.getId()+"  "+request.getData().length);
		}
	}

}
