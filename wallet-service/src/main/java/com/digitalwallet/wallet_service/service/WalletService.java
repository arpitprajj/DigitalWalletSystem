package com.digitalwallet.wallet_service.service;

import com.digitalwallet.wallet_service.entity.Wallet;
import com.digitalwallet.wallet_service.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {
    @Autowired
    WalletRepository walletRepository;
    public Wallet createWallet(String userName) {
       if (walletRepository.findByUserName(userName).isPresent()) {
           throw new RuntimeException("Wallet already exists for this user");
       }
        Wallet wallet=new Wallet();
        wallet.setUserName(userName);
        wallet.setBalance(0.0);
        return  wallet;
    }

    public Double getBalance(String userName) {
        Wallet wallet=this.walletRepository.findByUserName(userName).orElseThrow(()->new RuntimeException("user not found"));
        return wallet.getBalance();
    }

    public Wallet deposit(String userId, Double amount) {
        Wallet wallet=this.walletRepository.findByUserName(userId).orElseThrow(()->new RuntimeException("user not found"));
        Double amt=wallet.getBalance()+amount;
        wallet.setBalance(amt);
        return walletRepository.save(wallet);
    }

    public Wallet withdraw(String userId, Double amount) {
        Wallet wallet=this.walletRepository.findByUserName(userId).orElseThrow(()->new RuntimeException("user not found"));
        Double amt=wallet.getBalance();
        if(amount>amt)
            throw new RuntimeException("Amount not sufficient");
        amt-=amount;
        wallet.setBalance(amt);
        return walletRepository.save(wallet);
    }
}
