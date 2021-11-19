package com.cg.wallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.wallet.exception.FundTransferException;
import com.cg.wallet.exception.WalletException;

@RestControllerAdvice
public class WalletControllerAdvice {

	@ExceptionHandler(WalletException.class)
	public ResponseEntity<Error> getWalletByIdException(WalletException e) {

		return new ResponseEntity<Error>(new Error(e.getMessage()) , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FundTransferException.class)
	public ResponseEntity<String> fundTransferException(WalletException e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> defaultException(WalletException e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	}
		
	
	
}
