package com.voteroid.APIClusterNode.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.voteroid.APIClusterNode.dtos.ExceptionFieldsDTO;
import com.voteroid.APIClusterNode.dtos.Messages;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoAPIIDRecieved.class)
	public ResponseEntity<Object> handleNoAPIIDRecieved(NoAPIIDRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_API_ID_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoAPIMethodNameRecieved.class)
	public ResponseEntity<Object> handleNoAPIMethodNameRecieved(NoAPIMethodNameRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_CLIENT_information_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoAPIFound.class)
	public ResponseEntity<Object> handleNoAPIFound(NoAPIFound ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_API_FOUND);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoAPIUriPresent.class)
	public ResponseEntity<Object> handleNoAPIURIFound(NoAPIUriPresent ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.NO_API_URI_RECIEVED);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodChangeNotAllowed.class)
	public ResponseEntity<Object> handleNoAPIURIFound(MethodChangeNotAllowed ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.METHOD_CHANGE_NOT_ALLOWED);
        return new ResponseEntity<>(body, HttpStatus.NOT_MODIFIED);
	}
	@ExceptionHandler(PathChangeNotAllowed.class)
	public ResponseEntity<Object> handleNoAPIURIFound(PathChangeNotAllowed ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.PATH_CHANGE_NOT_ALLOWED);
        return new ResponseEntity<>(body, HttpStatus.NOT_MODIFIED);
	}
	@ExceptionHandler(URIChangeNotAllowed.class)
	public ResponseEntity<Object> handleNoAPIURIFound(URIChangeNotAllowed ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),Messages.Exceptions.URI_CHANGE_NOT_ALLOWED);
        return new ResponseEntity<>(body, HttpStatus.NOT_MODIFIED);
	}
	@ExceptionHandler(DataNotRecieved.class)
	public ResponseEntity<Object> handleNoAPIURIFound(DataNotRecieved ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SomethingWentWrong.class)
	public ResponseEntity<Object> handleNoAPIURIFound(SomethingWentWrong ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserAuthenticationFailed.class)
	public ResponseEntity<Object> handleNoAPIMethodNameRecieved(UserAuthenticationFailed ex) {
		ExceptionFieldsDTO body = new ExceptionFieldsDTO(LocalDateTime.now(),ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
	}
}
