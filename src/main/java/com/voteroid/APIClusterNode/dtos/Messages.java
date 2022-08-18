package com.voteroid.APIClusterNode.dtos;

public interface Messages {
	
	interface Exceptions{
		public static final String NO_API_ID_RECIEVED = "No API ID Recieved!!!" ;
		public static final String NO_CLIENT_information_RECIEVED = "No API Method Recieved !!!";
		public static final String NO_API_FOUND = "OOPS :( No API Found for this API ID !!";
		public static final String NO_API_URI_RECIEVED = "No API URI Recieved!!!";
		public static final String METHOD_CHANGE_NOT_ALLOWED = "Method Name Change is Not Allowed !!";
		public static final String PATH_CHANGE_NOT_ALLOWED = "Path Change is Not Allowed !!";
		public static final String URI_CHANGE_NOT_ALLOWED = "URI Change is Not Allowed !!";;
	}
	
	interface Responses{
		public static final String API_SAVED_SUCCESSFULLY = "API Saved Successfully !!!";
		public static final Object API_UPDATED_SUCCESSFULLY = "API Updated Successfully !!!";
	}
	
}
