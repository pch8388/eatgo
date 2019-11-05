package me.study.eatgo.application;

import me.study.eatgo.domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserServiceTests {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void getUsers() {
        List<User> users = userService.getUsers();

        User user = users.get(0);
        assertThat(user.getName(), is("테스터"));
    }
}