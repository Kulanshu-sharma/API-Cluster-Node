package com.voteroid.APIClusterNode.dtos;

public interface Messages {
	
	interface Exceptions{
		public static final String NO_API_ID_RECIEVED = "No API ID Recieved!!!" ;
		public static final String NO_CLIENT_information_RECIEVED = "No API Method Recieved !!!";
		public static final String NO_API_FOUND = "OOPS :( No API Found for this API ID !!";
		public static final String NO_API_URI_RECIEVED = "No API URI Recieved!!!";
	}
	
	interface Responses{
		public static final String API_SAVED_SUCCESSFULLY = "API Saved Successfully !!!";
	}
	
}
