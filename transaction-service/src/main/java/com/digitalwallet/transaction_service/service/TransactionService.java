package com.digitalwallet.transaction_service.service;

import com.digitalwallet.transaction_service.entity.Transaction;
import com.digitalwallet.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getUserTransactions(Long userId) {
        return repository.findByUserId(userId);
    }
}
