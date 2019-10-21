package me.study.eatgo.interfaces;

import me.study.eatgo.application.ReviewService;
import me.study.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create(
        @PathVariable("restaurantId") Long restaurantId,
        @RequestBody @Valid Review resource) throws URISyntaxException {

        Review review = reviewService.addReview(resource);
        String url = "/restaurants/" + restaurantId +
            "/reviews/" + review.getId();
        return ResponseEntity.created(new URI(url))
            .body("{}");
    }
}
