package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.dto.Wallet;
import com.cg.wallet.dto.WalletTransfer;
import com.cg.wallet.exception.FundTransferException;
import com.cg.wallet.exception.WalletException;



public interface WalletService {
	public Wallet createWallet(Wallet wallet);

	public Wallet getWallet(Integer id) throws WalletException ;

	public Wallet updateBalance(Wallet wallet);

	public Boolean deleteWallet(Integer id);
	public Boolean transferFund(WalletTransfer walletTransfer)throws FundTransferException;

	public List<Wallet> getWallets();
	
	
}
