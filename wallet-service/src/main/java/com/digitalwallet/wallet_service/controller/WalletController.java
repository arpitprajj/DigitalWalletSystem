package com.digitalwallet.wallet_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class WalletController {

    @GetMapping("/home")
    public  String home(){
        return "This homepage of Wallet";
    }

}
