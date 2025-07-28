package com.digitalwallet.transaction_service.dto;

import lombok.Data;

@Data
public class TransactionRequest {
    private Double amount;
    private String type; // CREDIT / DEBIT
}
