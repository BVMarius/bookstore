package com.randomhouse.bookstore.controllers.impl;

import com.randomhouse.bookstore.controllers.api.ProfileApi;
import com.randomhouse.bookstore.services.UserService;
import com.randomhouse.bookstore.utils.Constants;
import com.randomhouse.bookstorecontrollers.model.LoginRequest;
import com.randomhouse.bookstorecontrollers.model.LoginResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController implements ProfileApi {

    private final UserService userService;

    @Override
    public ResponseEntity<LoginResponse> postProfile(@Valid @RequestBody LoginRequest body
    ) {
        String token = userService.getToken(body.getEmail(), body.getPassword());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setTokenType(Constants.TOKEN_TYPE);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
