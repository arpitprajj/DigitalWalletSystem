package com.digitalwallet.wallet_service.controller;

import com.digitalwallet.wallet_service.dto.JwtUtil;
import com.digitalwallet.wallet_service.entity.Wallet;
import com.digitalwallet.wallet_service.service.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;
    private final JwtUtil jwtUtil;

    private String getUserIdFromToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        System.out.println("token "+token);
        return jwtUtil.extractUsername(token);
    }

    @PostMapping("/create")
    public ResponseEntity<Wallet> createWallet(HttpServletRequest request) {

        String userId = getUserIdFromToken(request);
        System.out.println("userId "+userId);
        Wallet wallet = walletService.createWallet(userId);
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance(HttpServletRequest request) {
        String userId = getUserIdFromToken(request);
        Double balance = walletService.getBalance(userId);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Wallet> deposit(HttpServletRequest request,
                                          @RequestParam Double amount) {
        String userId = getUserIdFromToken(request);
        Wallet wallet = walletService.deposit(userId, amount);
        return ResponseEntity.ok(wallet);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Wallet> withdraw(HttpServletRequest request,
                                           @RequestParam Double amount) {
        String userId = getUserIdFromToken(request);
        Wallet wallet = walletService.withdraw(userId, amount);
        return ResponseEntity.ok(wallet);
    }
}
