package com.yieldstreet.home.challenge.response;

public class UserAccreditationResponse extends GenericResponse{

	private boolean accredited;

	public boolean isAccredited() {
		return accredited;
	}

	public void setAccredited(boolean accredited) {
		this.accredited = accredited;
	}
}
