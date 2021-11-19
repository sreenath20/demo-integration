package com.cg.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.wallet.dto.Wallet;
@Repository
public interface WalletDao extends JpaRepository<Wallet,Integer>{

}
