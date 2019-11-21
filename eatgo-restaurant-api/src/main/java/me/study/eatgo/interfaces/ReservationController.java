package me.study.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import me.study.eatgo.application.ReservationService;
import me.study.eatgo.domain.Reservation;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> list(
        Authentication authentication
    ) {
        Claims claims = (Claims) authentication.getPrincipal();
        Long restaurantId = claims.get("restaurantId", Long.class);

        return reservationService.getReservations(restaurantId);
    }
}
