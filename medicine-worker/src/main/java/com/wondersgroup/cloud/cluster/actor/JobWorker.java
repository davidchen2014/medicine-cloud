package com.wondersgroup.cloud.cluster.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class JobWorker extends UntypedActor {

	private LoggingAdapter logger = Logging.getLogger(super.getContext().system(), this);

	@Override
	public void onReceive(Object message) throws Exception {
		System.out.println("remote nimanimanimanimanimanimanima");
		logger.info("remote worker receiveMessage:---" + message);
	}

}
