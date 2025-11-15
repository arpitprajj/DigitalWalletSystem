package com.wallet.user_service.serviceImpl;

import com.wallet.user_service.dto.AuthResponse;
import com.wallet.user_service.dto.Helper;
import com.wallet.user_service.dto.MyDetails;
import com.wallet.user_service.entity.User;
import com.wallet.user_service.repository.UserRepository;
import com.wallet.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserRepository userRepo;

    @Autowired
    Helper help;

    @Override
    public MyDetails getDetails(String userMail) {
        User user=userRepo.findByEmail(userMail).orElseThrow(()->new RuntimeException("User Not found"));

        String url = "http://localhost:8081/api/wallet/balance";
        System.out.println("Calling Rest Template");
        System.out.println(help.getCurrentToken());
        HttpHeaders headers = new HttpHeaders();


        headers.set("Authorization", "Bearer " +help.getCurrentToken());

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Double> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                Double.class
        );

        Double amount=response.getBody();
        MyDetails details=new MyDetails();
        details.setId(user.getId());
        details.setBalance(amount);
        details.setEmail(user.getEmail());
        details.setName(user.getName());
        return details;


    }
}
