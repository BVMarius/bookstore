package com.randomhouse.bookstore.services;

import com.randomhouse.bookstore.entities.UserEntity;
import com.randomhouse.bookstore.exceptions.AuthorizationException;
import com.randomhouse.bookstore.repositories.UserRepository;
import com.randomhouse.bookstore.utils.Auth0JwtTools;
import com.randomhouse.bookstore.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Auth0JwtTools auth0JwtTools;

    @Override
    public void createUser(UserEntity userEntity) {

        userRepository.findByEmail(userEntity.getEmail())
                .ifPresentOrElse(userEntity1 ->

                                log.info("User with email {} is already present in database",
                                        userEntity.getEmail()) ,
                        () -> {
                            userEntity
                                    .setPassword(passwordEncoder.encode(userEntity.getPassword()));
                            userRepository.save(userEntity);
                        });


    }

    @Override
    public String getToken(String email, String password) {

        UserEntity u = userRepository.findByEmail(email)
                .orElseThrow(() -> new AuthorizationException(
                        Constants.ACCESS_DENIED, Constants.ACCESS_DENIED_CODE));
        if (!(passwordEncoder.encode(password).equals(u.getPassword()))) {
            log.info("Invalid password");
            throw new AuthorizationException(
                    Constants.ACCESS_DENIED, Constants.ACCESS_DENIED_CODE);
        }
        return auth0JwtTools.createJwt(u.getId().toString(), (long) 3600);

    }
}
