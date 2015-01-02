package com.wondersgroup.cloud.cluster.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class RestInterface extends UntypedActor {

	private ActorRef master;

	public RestInterface(ActorRef master) {
		this.master = master;
	}

	@Override
	public void onReceive(Object message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("rest===" + message);
	}

}
