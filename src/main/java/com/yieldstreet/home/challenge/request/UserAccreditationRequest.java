package com.yieldstreet.home.challenge.request;

import com.yieldstreet.home.challenge.model.AccreditationProof;

public class UserAccreditationRequest {
	private String userId;
	private AccreditationProof payload;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AccreditationProof getPayload() {
		return payload;
	}

	public void setPayload(AccreditationProof payload) {
		this.payload = payload;
	}
}
