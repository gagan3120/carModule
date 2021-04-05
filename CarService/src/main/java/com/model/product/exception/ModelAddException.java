package com.model.product.exception;

public class ModelAddException extends RuntimeException {
	/**************************************************************************
	 * @author                 G Gagandeep Reddy
	 * Description             It is an exception class that handles the exception that occurs at 
	 *                         service level
	 * version                 1.0
	 * created date            25-03-2021
	 *
	 ************************************************************************************/
	private static final long serialVersionUID = 1L;

	public ModelAddException(String message) {
		super(message);
	
	}
}
