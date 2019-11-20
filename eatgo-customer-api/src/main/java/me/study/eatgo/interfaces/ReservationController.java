package me.study.eatgo.interfaces;

import me.study.eatgo.application.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/restaurants/{restaurantId}/reservations")
    public ResponseEntity<?> create(
        @PathVariable Long restaurantId
    ) throws URISyntaxException {
        Long userId = 1L;
        String name = "Tester";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;

        reservationService.addReservation(userId, name, date, time, partySize);

        String url = "/restaurants/"+restaurantId+"/reservations/1";
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
