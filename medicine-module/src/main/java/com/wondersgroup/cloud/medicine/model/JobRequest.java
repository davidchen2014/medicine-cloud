package com.wondersgroup.cloud.medicine.model;

import java.io.Serializable;

public class JobRequest implements Serializable {

	private String id;
	private RootData[] data;

	public JobRequest() {
	}

	public JobRequest(String id, RootData[] data) {
		this.id = id;
		this.data = data;
	}

	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RootData[] getData() {
		return data;
	}

	public void setData(RootData[] data) {
		this.data = data;
	}


}
