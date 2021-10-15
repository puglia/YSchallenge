package com.yieldstreet.home.challenge.aspect;

import javax.ws.rs.core.Response;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ErrorHandlingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution(* com.yieldstreet.home.challenge.controller.*.*(..))")
	public Object controllerCallLog(ProceedingJoinPoint joinPoint) {
		Response response;
		try {
			response = (Response)joinPoint.proceed(); 
		}catch (IllegalArgumentException ex) {
			logger.error(ex.getMessage());
			return Response.status(401).build();
		}catch (Throwable e) {
			logger.error(e.getMessage());
			return Response.status(500).entity(e.getMessage()).build();
		}
		
		return response;
	}
	
}
