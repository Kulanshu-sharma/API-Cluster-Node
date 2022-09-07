package com.voteroid.APIClusterNode.exceptions;

public class SomethingWentWrong extends RuntimeException{

	private static final long serialVersionUID = 6818468135490951584L;
	
	private String message;

	public SomethingWentWrong(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
