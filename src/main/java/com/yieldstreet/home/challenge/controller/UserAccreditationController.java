package com.yieldstreet.home.challenge.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.yieldstreet.home.challenge.request.UserAccreditationRequest;
import com.yieldstreet.home.challenge.response.UserAccreditationResponse;
import com.yieldstreet.home.challenge.service.UserAcreditationService;

@Service
@Path("/user")
public class UserAccreditationController {

	@Inject
	UserAcreditationService service;

	@POST
	@Path("/accreditation")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validate(UserAccreditationRequest req) {
		try {
			UserAccreditationResponse resp = new UserAccreditationResponse();
			resp.setSuccess(true);
			resp.setAccredited(service.verify(req.getPayload()));
			return Response.status(200).entity(resp).build();
		} catch (IllegalArgumentException ex) {
			return Response.status(401).build();
		} catch (Exception ex) {
			return Response.status(500).build();
		}
	}
}