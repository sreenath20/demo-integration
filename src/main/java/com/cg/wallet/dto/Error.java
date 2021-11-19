package com.cg.wallet.dto;

public class Error {
	private String message;

	public Error(String message) {
		super();
		this.message = message;
	}
	public Error() {

	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
