package me.study.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTests {

    @Test
    public void creation() {
        User user = User.builder()
            .email("tester@example.com")
            .name("테스터")
            .level(100L)
            .build();

        assertThat(user.getName(), is("테스터"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deactivate();
        assertThat(user.isActive(), is(false));

    }

    @Test
    public void restaurantOwner() {
        User user = User.builder().level(1L).build();

        assertThat(user.isRestaurantOwner(), is(false));

        user.setRestaurantId(1004L);

        assertThat(user.isRestaurantOwner(), is(true));
    }
}