package com.cg.wallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.dto.Wallet;
import com.cg.wallet.dto.WalletTransfer;
import com.cg.wallet.exception.FundTransferException;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.WalletService;


/************************************************************************************
 *          @author          Ram Kumar
 *          Description      It is a service class that provides the services for adding anew account, 
                                        transferring fund and viewing all the accounts  
  *         Version             1.0
  *         Created Date    02-APR-2020
 ************************************************************************************/

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WalletController {

	@Autowired
	private WalletService walletService;

	@GetMapping("/")
	public String greeting() {
		return "Hello Controller";
	}
	/************************************************************************************
	 * Method: transferFund
                *Description: To transfer the fund from one account to another account
	 * @param fromAccountID       - Sender’s Account ID
	 * @param toAccountID            - Reciepent Account ID
	 * @param amt                           - Amount to be Transferred
	 * @returns Boolean                  - true, if transferred otherwise throws AccountException
	 * @throws AccountException - It is raised due to insufficient balance or invalid account Id or  
                                                                         server side validation
                *Created By                                - Ram kumar
                *Created Date                            - 7-APR-2020                           
	 
	 ************************************************************************************/
	@GetMapping("wallet")
	public ResponseEntity<List<Wallet>> getWallets() throws WalletException {

		
		return new ResponseEntity<>(walletService.getWallets(), HttpStatus.OK);
	}
	
	@PostMapping("wallet")
	public Wallet createWallet(@Valid @RequestBody Wallet walletObj, BindingResult bindingResult)
			throws WalletException {

		StringBuilder errorMessage = new StringBuilder();
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors)
				errorMessage.append(error.getDefaultMessage() + " ");
			throw new WalletException(errorMessage.toString());
		}

		Wallet wallet = walletService.createWallet(walletObj);
		return wallet;
	}

	@GetMapping("wallet/{id}")
	public ResponseEntity<Wallet> getWalletById(@PathVariable Integer id) throws WalletException {

		Wallet wallet;

		try {
			wallet = walletService.getWallet(id);
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			throw e; // rethrow exception object
		}

		return new ResponseEntity<>(wallet, HttpStatus.OK);
	}

	@PutMapping("wallet")
	public Wallet addBalance(@RequestBody Wallet wallet) {
		return walletService.updateBalance(wallet);
	}

	@DeleteMapping("wallet/{id}")
	public String deleteWallet(@PathVariable Integer id) {

		if (walletService.deleteWallet(id))
			return "Wallet Deleted .";
		else
			return "Wallet could't be Deleted .";
	}

	@PutMapping("fundtransfer")
	public String transferFund(@RequestBody WalletTransfer walletTransfer) throws FundTransferException {

		// complete the logic
		try {
			if (walletService.transferFund(walletTransfer))

				return "Fund Traansfer Successful.";
			else
				return "Fund Traansfer faild.";
		} catch (FundTransferException e) {
			// TODO Auto-generated catch block
			
			throw e;
		}

	}

}
