package com.wondersgroup.cloud.cluster.actor;

import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberRemoved;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ClusterDomainEventListener extends UntypedActor {

	private LoggingAdapter log = Logging.getLogger(super.getContext().system(), this);
	private Cluster cluster = Cluster.get(super.getContext().system());

	@Override
	public void preStart() throws Exception {
		// super.preStart();
		this.cluster.subscribe(super.getSelf(), ClusterEvent.initialStateAsEvents(), MemberEvent.class,
				UnreachableMember.class);
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof MemberUp) {
			MemberUp mUp = (MemberUp) message;
			log.info("Member is Up: {}", mUp.member());

		} else if (message instanceof UnreachableMember) {
			UnreachableMember mUnreachable = (UnreachableMember) message;
			log.info("Member detected as unreachable: {}", mUnreachable.member());

		} else if (message instanceof MemberRemoved) {
			MemberRemoved mRemoved = (MemberRemoved) message;
			log.info("Member is Removed: {}", mRemoved.member());

		} else if (message instanceof MemberEvent) {
			// ignore

		} else {
			unhandled(message);
		}
	}

	@Override
	public void postStop() throws Exception {
		this.cluster.unsubscribe(this.getSelf());
	}

}
