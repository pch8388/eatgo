package me.study.eatgo.interfaces;

import me.study.eatgo.application.RestaurantService;
import me.study.eatgo.domain.MenuItem;
import me.study.eatgo.domain.Restaurant;
import me.study.eatgo.domain.RestaurantNotFoundException;
import me.study.eatgo.interfaces.RestaurantController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(Restaurant.builder()
            .id(1004L)
            .categoryId(1L)
            .name("JOKER House")
            .address("Seoul")
            .build());

        given(restaurantService.getRestaurants("Seoul", 1L))
                .willReturn(restaurants);

        mvc.perform(get("/restaurants?region=Seoul&category=1"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("\"id\":1004")))
            .andExpect(content().string(
                containsString("\"name\":\"JOKER House\"")));

    }

    @Test
    public void detailWithExisted() throws Exception {
        Restaurant restaurant1 = Restaurant.builder()
            .id(1004L)
            .name("JOKER House")
            .address("Seoul")
            .build();

        MenuItem menuItem = MenuItem.builder()
            .name("Kimchi")
            .build();

        restaurant1.setMenuItems(Arrays.asList(menuItem));

        Restaurant restaurant2 = Restaurant.builder()
            .id(2020L)
            .name("Cyber Food")
            .address("Seoul")
            .build();

        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant1);
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);

        mvc.perform(get("/restaurants/1004"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("\"id\":1004")))
            .andExpect(content().string(
                containsString("\"name\":\"JOKER House\"")))
            .andExpect(content().string(
                containsString("Kimchi")
            ));

        mvc.perform(get("/restaurants/2020"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("\"id\":2020")))
            .andExpect(content().string(
                containsString("\"name\":\"Cyber Food\"")));
    }

    @Test
    public void detailWithNotExisted() throws Exception {
        given(restaurantService.getRestaurant(404L))
            .willThrow(new RestaurantNotFoundException(404L));

        mvc.perform(get("/restaurants/404"))
            .andExpect(status().isNotFound())
            .andExpect(content().string("{}"));
    }

}