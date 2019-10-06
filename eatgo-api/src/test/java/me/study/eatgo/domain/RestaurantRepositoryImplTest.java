package me.study.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantRepositoryImplTest {

    @Test
    public void save() {
        RestaurantRepository repository = new RestaurantRepositoryImpl();

        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong", "Seoul");
        repository.save(restaurant);

        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount, is(1));
    }

}