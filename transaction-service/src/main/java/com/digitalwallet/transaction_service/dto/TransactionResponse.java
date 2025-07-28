package com.digitalwallet.transaction_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionResponse {
    private String message;
    private Double updatedBalance;
}
