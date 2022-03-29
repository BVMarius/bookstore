package com.randomhouse.bookstore.utils;

import com.randomhouse.bookstore.exceptions.BadRequestBodyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class UserRequestValidationHandler {

    public void validateStringNotNullAndNotEmpty(String name){

        if ((name == null)||(name.isEmpty())) {
            throw new BadRequestBodyException(Constants.INCORRECT_BODY, Constants.INCORRECT_BODY_CODE);
        }
    }

    public void validateEmail(String emailAddress){

        var pat = Pattern.compile("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+.[a-zA-Z0-9]+");
        var matcher = pat.matcher(emailAddress);
        if(!matcher.matches()){
            throw new BadRequestBodyException(Constants.INCORRECT_EMAIL,Constants.INCORRECT_EMAIL_CODE);
        }
    }

}
