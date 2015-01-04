package com.wondersgroup.cloud.medicine.model;

import java.io.Serializable;

public class RootData implements Serializable {

	private static final long serialVersionUID = 1L;

	private OrganPart organ;
	private TimePart time;
	private QueuePart queue;

	private String id;

	public OrganPart getOrgan() {
		return organ;
	}

	public void setOrgan(OrganPart organ) {
		this.organ = organ;
	}

	public TimePart getTime() {
		return time;
	}

	public void setTime(TimePart time) {
		this.time = time;
	}

	public QueuePart getQueue() {
		return queue;
	}

	public void setQueue(QueuePart queue) {
		this.queue = queue;
	}

	public RootData initOrgan(String path) {
		OrganPart organ = new OrganPart();
		organ.setPath(path);
		this.setOrgan(organ);
		return this;
	}

	public RootData initTime(String version) {
		TimePart time = new TimePart();
		time.setValue(version);
		this.setTime(time);
		return this;
	}

	public RootData initQueue(String value) {
		QueuePart queue = new QueuePart();
		queue.setValue(value);
		this.setQueue(queue);
		return this;
	}

	@Override
	public String toString() {
		return this.organ.toString() + this.time.toString()
				+ this.queue.toString();
	}

	public RootData initId(String id) {
		this.id = id;
		return this;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
