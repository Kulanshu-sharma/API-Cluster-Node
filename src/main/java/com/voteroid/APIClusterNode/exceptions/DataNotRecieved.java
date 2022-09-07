package com.voteroid.APIClusterNode.exceptions;

public class DataNotRecieved extends RuntimeException {

	private static final long serialVersionUID = 4732975204091194361L;
	
	private String message;

	public DataNotRecieved(String field,String fieldRequired, String dataType) {
		super();
		this.message = "No "+field+" is Recieved!!! Field Required is - "+fieldRequired+" [ "+dataType+" ]";
	}

	public String getMessage() {
		return message;
	}
		
}
