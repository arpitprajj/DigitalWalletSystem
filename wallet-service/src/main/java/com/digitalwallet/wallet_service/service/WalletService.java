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
    public Wallet createWallet(Long userId) {
       if (walletRepository.findByUserId(userId).isPresent()) {
           throw new RuntimeException("Wallet already exists for this user");
       }
        Wallet wallet=new Wallet();
        wallet.setUserId(userId);
        wallet.setBalance(0.0);
        return  walletRepository.save(wallet);
    }

    public Double getBalance(Long userId) {
        Wallet wallet=this.walletRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("user not found"));
        return wallet.getBalance();
    }

    public Wallet deposit(Long userId, Double amount) {
        Wallet wallet=this.walletRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("user not found"));
        Double amt=wallet.getBalance()+amount;
        wallet.setBalance(amt);
        return walletRepository.save(wallet);
    }

    public Wallet withdraw(Long userId, Double amount) {
        Wallet wallet=this.walletRepository.findByUserId(userId).orElseThrow(()->new RuntimeException("user not found"));
        Double amt=wallet.getBalance();
        if(amount>amt)
            throw new RuntimeException("Amount not sufficient");
        amt-=amount;
        wallet.setBalance(amt);
        return walletRepository.save(wallet);
    }
}
