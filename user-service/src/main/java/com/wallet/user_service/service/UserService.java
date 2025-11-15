package com.wallet.user_service.service;

import com.wallet.user_service.dto.MyDetails;

public interface UserService {

    MyDetails getDetails(String userMail);
}
