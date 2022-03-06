package com.randomhouse.bookstore.controllers.validators;

import com.randomhouse.bookstore.exceptions.BadRequestBodyException;
import com.randomhouse.bookstore.utils.Constants;
import com.randomhouse.bookstorecontrollers.model.UserRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        final var user = (UserRequest) target;
        String email = user.getEmail();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String password = user.getPassword();

        if (StringUtils.isAnyBlank(email, firstName, lastName, password)) {
            throw new BadRequestBodyException(Constants.CAN_T_BE_BLANK,
                    Constants.CAN_T_BE_BLANK_CODE);
        }

        if (!validateEmail(email)) {
            throw new BadRequestBodyException(Constants.INCORRECT_EMAIL,
                    Constants.INCORRECT_EMAIL_CODE);
        }


    }


    private boolean validateEmail(String emailAddress) {

        Pattern pat = Pattern.compile("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9]+");
        Matcher matcher = pat.matcher(emailAddress);
        return matcher.matches();

    }
}

