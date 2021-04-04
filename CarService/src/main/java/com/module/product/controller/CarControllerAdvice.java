package com.module.product.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.model.product.exception.ModelAddException;
import com.model.product.exception.ModelDeleteException;
import com.model.product.exception.ModelEmptyListException;
import com.model.product.exception.ModelNotFoundException;
import com.model.product.exception.ModelUpdateException;

@RestControllerAdvice
public class CarControllerAdvice {
	@ExceptionHandler(ModelNotFoundException.class)
	public String carNotFoundException(Exception e1) {
		return e1.getMessage();

	}

	@ExceptionHandler(ModelUpdateException.class)
	public String carUpdateException(Exception e2) {
		return e2.getMessage();

	}

	@ExceptionHandler(ModelEmptyListException.class)
	public String carEmptyListException(Exception e3) {
		return e3.getMessage();

	}

	@ExceptionHandler(ModelDeleteException.class)
	public String carDeleteException(Exception e4) {
		return e4.getMessage();

	}

	@ExceptionHandler(ModelAddException.class)
	public String carAddException(Exception e5) {
		return e5.getMessage();

	}

}
