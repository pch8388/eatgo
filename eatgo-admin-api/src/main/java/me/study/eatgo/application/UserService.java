package me.study.eatgo.application;

import me.study.eatgo.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
            .email("tester@example.com")
            .name("테스터")
            .level(1L)
            .build());

        return users;
    }
}
