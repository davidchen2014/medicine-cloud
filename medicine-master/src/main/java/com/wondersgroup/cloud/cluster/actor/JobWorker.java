package com.wondersgroup.cloud.cluster.actor;

import com.wondersgroup.cloud.medicine.model.JobRequest;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class JobWorker extends UntypedActor {

	private LoggingAdapter logger = Logging.getLogger(super.getContext().system(), this);

	@Override
	public void onReceive(Object message) throws Exception {
		logger.info("local worker receiveMessage:---" + message);
		if (message instanceof JobRequest) {
			// todo通过spring extension注入获得service
			JobRequest request = (JobRequest) message;
			logger.info("local worker receiveMessage:---" + request.getData().length);
		}
	}

}
