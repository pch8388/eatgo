package me.study.eatgo.application;

import me.study.eatgo.domain.User;
import me.study.eatgo.domain.UserNotFoundException;
import me.study.eatgo.domain.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(String email, String name) {
        User user =  User.builder()
                .email(email)
                .name(name)
                .build();
        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name, Long level) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));

        user.setEmail(email);
        user.setName(name);
        user.setLevel(level);

        return user;
    }

    public User deactiveUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        return user;
    }
}
