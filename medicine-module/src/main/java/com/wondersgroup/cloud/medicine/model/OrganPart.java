package com.wondersgroup.cloud.medicine.model;

import java.io.Serializable;

public class OrganPart implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
