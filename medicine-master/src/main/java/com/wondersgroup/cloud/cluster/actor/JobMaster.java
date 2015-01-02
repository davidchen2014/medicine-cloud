package com.wondersgroup.cloud.cluster.actor;

import com.wondersgroup.cloud.medicine.model.JobRequest;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.FromConfig;

public class JobMaster extends UntypedActor {

	private LoggingAdapter logger = Logging.getLogger(super.getContext().system(), this);
//	private ActorRef worker = getContext().actorOf(FromConfig.getInstance().props(), "factorialBackendRouter");

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return SupervisorStrategy.stoppingStrategy();
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof JobRequest) {
			JobRequest content = (JobRequest) message;
			logger.info("master---content：：：" + content.getId());
			
//			ActorRef parent = getContext().actorFor("/user/cluster-acceptor");
//			ActorRef worker =  getContext().a(Props.apply(arg0)parent, "factorialBackendRouter");
//			worker.tell(content, super.getSelf());
		}
	}

}
