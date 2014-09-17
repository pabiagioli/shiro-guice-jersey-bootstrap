package com.pampanet.sample.rest.exception;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Exception Response Bean to handle any type of Exceptions being thrown by REST Resources
 * @author pablo.biagioli
 *
 */
@XmlRootElement
public class ExceptionResponse {

	private String cause;
	private String message;
	
	public ExceptionResponse() {
	}
	
	public ExceptionResponse(String cause,String message){
		this.cause = cause;
		this.message = message;
	}
	
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
