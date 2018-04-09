package com.youtube.demo.util;

import org.springframework.http.HttpStatus;

public class RestResponse {

	private Integer responseCode;
	private String message;
	
	public RestResponse(Integer responseCode, String string) {
		super();
		this.responseCode = responseCode;
	}
	
	public RestResponse(HttpStatus[] httpStatus, String message) {
		super();
		this.responseCode = httpStatus;
		this.message = message;
	}
	
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
