package com.yieldstreet.home.challenge.service;

import org.springframework.stereotype.Service;

import com.yieldstreet.home.challenge.model.AccreditationProof;

@Service
public class UserAcreditationService {

	public boolean verify(AccreditationProof proof) {
		
		return Math.random() > 0.49;
	}
	
}
