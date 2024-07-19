package com.farm.collector.exception;

import java.io.Serializable;

public class HarvestedException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 5493040836973293034L;
	private String errorMessage;

	public HarvestedException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
