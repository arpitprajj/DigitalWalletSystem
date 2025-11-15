package com.wallet.user_service.controller;

import com.wallet.user_service.dto.MyDetails;
import com.wallet.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/home")
    public String Home(){
       return "Welcome My Friends";


    }
    @GetMapping("/myDetails/{userMail}")
    public ResponseEntity<MyDetails> getDetails(@PathVariable String userMail){
        System.out.println("Into My Details");
        MyDetails details=userService.getDetails(userMail);

        return ResponseEntity.ok(details);
    }
}
