package com.yieldstreet.home.challenge.response;

public abstract class GenericResponse {

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
