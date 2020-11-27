package com.wf.training.bootrestfulcrud.dto.exception;

public class ExceptionResponse {
	
	private String message;
	private Long timestamp;
	private int status;
	
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ExceptionResponse(String message, Long timestamp, int status) {
		
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
	}



	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
