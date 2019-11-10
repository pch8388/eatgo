package me.study.eatgo.interfaces;

import me.study.eatgo.domain.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    public User registerUser(String email, String name, String password) {
        //TODO : 구현 필요

        return null;
    }
}
