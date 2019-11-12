package me.study.eatgo.application;

public class PasswordWrongException extends RuntimeException {

    public PasswordWrongException() {
        super("Password is wrong");
    }

}
