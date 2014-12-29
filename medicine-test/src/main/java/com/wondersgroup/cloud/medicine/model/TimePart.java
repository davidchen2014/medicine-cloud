package com.wondersgroup.cloud.medicine.model;

import java.io.Serializable;

public class TimePart implements Serializable {

	private static final long serialVersionUID = 1L;
	private long value;

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

}
