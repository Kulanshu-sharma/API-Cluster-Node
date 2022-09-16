package com.voteroid.APIClusterNode.exceptions;

public class UserAuthenticationFailed extends RuntimeException {

	private static final long serialVersionUID = 8500530802862801694L;
	
	private String message;

	public UserAuthenticationFailed(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
