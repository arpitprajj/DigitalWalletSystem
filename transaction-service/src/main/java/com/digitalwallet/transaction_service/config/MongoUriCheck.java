package com.digitalwallet.transaction_service.config;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MongoUriCheck {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @PostConstruct
    public void logMongoUri() {
        System.out.println("🔗 MongoDB URI picked up: " + mongoUri);
    }
}