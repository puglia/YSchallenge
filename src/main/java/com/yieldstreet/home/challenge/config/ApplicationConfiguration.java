package com.yieldstreet.home.challenge.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.yieldstreet.home.challenge.controller.UserAccreditationController;

@Configuration
public class ApplicationConfiguration extends ResourceConfig {

	public ApplicationConfiguration() {
		register(UserAccreditationController.class);
	}

}
