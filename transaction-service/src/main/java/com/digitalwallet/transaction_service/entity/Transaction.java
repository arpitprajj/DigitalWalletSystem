package com.digitalwallet.transaction_service.entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transaction")
public class Transaction {
    @Id
    private String id;

    private Long userId;
    private String type;    // CREDIT / DEBIT
    private Double amount;
    private String counterpartyUserId;
    private LocalDateTime timestamp;
}



