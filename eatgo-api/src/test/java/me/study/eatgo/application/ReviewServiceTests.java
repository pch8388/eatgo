package me.study.eatgo.application;

import me.study.eatgo.domain.Review;
import org.junit.Before;
import org.junit.Test;

public class ReviewServiceTests {

    private ReviewService reviewService;

    @Before
    public void setUp() {
        reviewService = new ReviewService();
    }

    @Test
    public void addReview() {
        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da")
                .build();

        reviewService.addReview(review);
    }
}