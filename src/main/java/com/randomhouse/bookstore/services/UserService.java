package com.randomhouse.bookstore.services;

import com.randomhouse.bookstore.entities.UserEntity;

public interface UserService {

     void createUser(UserEntity userEntity);
     String getToken(String email, String password);

}
