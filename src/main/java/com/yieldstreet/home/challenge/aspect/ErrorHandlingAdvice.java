package com.yieldstreet.home.challenge.aspect;

import static com.yieldstreet.home.challenge.util.ResponseFactory.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleBadRequest(Exception ex) {
		logger.error(ex.getMessage());
		return badRequest(ex.getMessage());
	}
	@ExceptionHandler(value = { Throwable.class })
	protected ResponseEntity<Object> handleInternalError(Throwable ex) {
		logger.error(ex.getMessage());
		return serverError(ex.getMessage());
	}
}
