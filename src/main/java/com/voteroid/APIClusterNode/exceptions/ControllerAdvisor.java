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
}
