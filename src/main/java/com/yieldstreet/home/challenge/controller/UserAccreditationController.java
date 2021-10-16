package com.yieldstreet.home.challenge.controller;

import static com.yieldstreet.home.challenge.util.ResponseFactory.ok;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yieldstreet.home.challenge.request.UserAccreditationRequest;
import com.yieldstreet.home.challenge.response.UserAccreditationResponse;
import com.yieldstreet.home.challenge.service.UserAccreditationService;

@RestController
@RequestMapping("/user")
public class UserAccreditationController {

	@Inject
	UserAccreditationService userAccreditationService;

	@PostMapping("/accreditation")
	public ResponseEntity<Object> validate(@RequestBody UserAccreditationRequest req) throws FileNotFoundException, IOException {
		UserAccreditationResponse resp = new UserAccreditationResponse();
		
		resp.setAccredited(userAccreditationService.verify(req.getPayload(), req.getUserId()));
		resp.setSuccess(true);
		return ok(resp);
	}
}
