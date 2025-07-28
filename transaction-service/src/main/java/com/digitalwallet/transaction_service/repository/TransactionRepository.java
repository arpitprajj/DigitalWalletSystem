package com.digitalwallet.transaction_service.repository;

import com.digitalwallet.transaction_service.entity.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String> {
    List<Transaction> findByUserId(String userId);


}
