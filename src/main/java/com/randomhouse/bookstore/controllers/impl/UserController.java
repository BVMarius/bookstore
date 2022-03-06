package com.randomhouse.bookstore.controllers.impl;

import com.randomhouse.bookstore.controllers.api.CustomerApi;
import com.randomhouse.bookstore.controllers.validators.UserValidator;
import com.randomhouse.bookstore.entities.UserEntity;
import com.randomhouse.bookstore.services.UserService;
import com.randomhouse.bookstorecontrollers.model.UserRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements CustomerApi {

    private final UserService userService;
    private final UserValidator userValidator;

    @InitBinder("userRequest")
    protected void userEntryInitBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @Override
    public ResponseEntity<Void> createCustomer(@Valid UserRequest body
    ) {

        UserEntity userEntity = UserEntity.builder().firstName(body.getFirstName())
                .lastName(body.getLastName()).email(body.getEmail())
                .userType(body.getUserType().toString()).password(body.getPassword()).build();
        userService.createUser(userEntity);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
