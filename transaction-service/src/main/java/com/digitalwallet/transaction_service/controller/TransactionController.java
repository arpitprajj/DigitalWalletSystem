package com.digitalwallet.transaction_service.controller;

//import com.digitalwallet.transaction_service.config.JwtUtil;
import com.digitalwallet.transaction_service.entity.Transaction;
import com.digitalwallet.transaction_service.repository.TransactionRepository;
import com.digitalwallet.transaction_service.service.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository repo;

    @Autowired
    //private JwtUtil jwtUtil;
    @GetMapping("/")
    public String greet(){
        return "Welcome Home";
    }
    @GetMapping("/list")
    public List<Transaction> list(){
        return repo.findAll();
    }
    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
//        String token = request.getHeader("Authorization").substring(7);
//        Long userId = jwtUtil.extractUserId(token);
//        transaction.setUserId(userId);
        return transactionService.addTransaction(transaction);
    }

@GetMapping("/history/{id}")
   public List<Transaction> getAllUserTransactions(@PathVariable Long id){//HttpServletRequest request) {
////        String token = request.getHeader("Authorization").substring(7);
////        Long userId = jwtUtil.extractUserId(token);
     return transactionService.getUserTransactions(id);
    }
}