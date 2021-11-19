package com.cg.wallet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.wallet.dao.WalletDao;
import com.cg.wallet.dto.Wallet;
import com.cg.wallet.dto.WalletTransfer;
import com.cg.wallet.exception.FundTransferException;
import com.cg.wallet.exception.WalletException;

/************************************************************************************
 * @author Ram Kumar Description It is a service class that provides the
 *         services for adding anew account, transferring fund and viewing all
 *         the accounts 
 * @Version 1.0 
 *         Created Date 02-APR-2020
 ************************************************************************************/
// ctrl + shift + f format your code
//@Component
@Service

public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletDao walletDao;

	@Override
	public Wallet createWallet(Wallet walletObj) {
		// TODO Auto-generated method stub

		return walletDao.saveAndFlush(walletObj);
	}

	@Override
	public Wallet getWallet(Integer id) throws WalletException {
		// TODO Auto-generated method stub

		Optional<Wallet> walletContainer = walletDao.findById(id);
		if (walletContainer.isEmpty())
			throw new WalletException("Wallet id :" + id + " does not exists.");
		else
			return walletContainer.get();

	}

	@Override
	public Wallet updateBalance(Wallet walletObj) {
		// TODO Auto-generated method stub
		Optional<Wallet> walletContainer = walletDao.findById(walletObj.getId());

		Wallet wallet = walletContainer.get();
		Double currentBalance = wallet.getBalance();
		Double newFund = walletObj.getBalance();

		wallet.setBalance(currentBalance + newFund);

		return walletDao.save(wallet);
	}

	@Override
	public Boolean deleteWallet(Integer id) {
		// TODO Auto-generated method stub
		Wallet wallet = walletDao.findById(id).get();
		walletDao.delete(wallet);
		return true;
	}

	@Override
	@Transactional
	public Boolean transferFund(WalletTransfer walletTransfer) throws FundTransferException {
		// TODO Auto-generated method stub

		Optional<Wallet> fromWallet = walletDao.findById(walletTransfer.getFromId());
		if (fromWallet.isEmpty())
			throw new FundTransferException("From Wallet does not exista!");

		Optional<Wallet> toWallet = walletDao.findById(walletTransfer.getToID());
		if (toWallet.isEmpty())
			throw new FundTransferException("Tranfer To Wallet does not exista!");

		if (fromWallet.get().getBalance() >= walletTransfer.getFund()) {
			Wallet fromAccount = fromWallet.get();
			fromAccount.setBalance(fromAccount.getBalance() - walletTransfer.getFund());
			Wallet toAccount = toWallet.get();
			toAccount.setBalance(toAccount.getBalance() + walletTransfer.getFund());
		} else {
			throw new FundTransferException("Ïnsufficent Balance!");
		}
		return true;
	}

	@Override
	public List<Wallet> getWallets() {
		// TODO Auto-generated method stub
		return walletDao.findAll();
	}

}
