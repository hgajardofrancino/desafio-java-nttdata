package com.nttdata.desafio.manager.user.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    @Value("${validator.password.pattern}")
    private String passwordPattern;

    @Value("${validator.password.message}")
    private String msgError;

    public void validate(String password) {

        if (!password.matches(passwordPattern)) {
            throw new IllegalArgumentException(msgError);
        }
    }
}
