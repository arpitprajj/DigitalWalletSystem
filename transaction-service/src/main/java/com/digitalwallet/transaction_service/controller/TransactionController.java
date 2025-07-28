package com.digitalwallet.transaction_service.controller;

import com.digitalwallet.transaction_service.entity.Transaction;
import com.digitalwallet.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class TransactionController {

    @Autowired
    TransactionRepository repo;
    @GetMapping("/")
    public String home(){
        return "This NoSQL WALA project";
    }
    @GetMapping("/transactions")
    public List<Transaction> getTransaction(){
        return repo.findAll();
    }
}
