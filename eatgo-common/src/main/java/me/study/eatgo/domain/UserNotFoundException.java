package me.study.eatgo.domain;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could Not Find " + id);
    }
}
