package com.springrest.nextpermutation.entities;

public class NextBigNumberResponseFormat {
	private String message;
	private String value;
	
	public NextBigNumberResponseFormat() {
		super();
		this.message = "";
		this.value = null;
	}

	public NextBigNumberResponseFormat(String message, String value) {
		super();
		this.value = value;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
