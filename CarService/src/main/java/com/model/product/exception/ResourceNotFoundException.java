package com.model.product.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**************************************************************************
	 * @author                 G Gagandeep Reddy
	 * Description             It is an exception class that handles the exception that occurs at 
	 *                         service level
	 * version                 1.0
	 * created date            25-03-2021
	 *
	 ************************************************************************************/

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
