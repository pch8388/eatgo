package me.study.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import me.study.eatgo.application.ReservationService;
import me.study.eatgo.domain.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReservationController {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/restaurants")
    public String list() {
        return "";
    }
}
