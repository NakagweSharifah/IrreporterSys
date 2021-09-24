package com.irreporter.exceptions;
public class SavingFailedException extends Exception {


	private static final long serialVersionUID = 1L;
	public SavingFailedException(String message){
		super("Reason for not saving:" + message);
	}


}
