package me.study.eatgo.application;

import me.study.eatgo.domain.Reservation;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReservationServiceTests {

    private ReservationService reservationService;

    @Before
    public void setUp() {
        reservationService = new ReservationService();
    }

    @Test
    public void addReservation() {
        Long restaurantId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;

        Reservation reservation = reservationService.addReservation(
            restaurantId, userId, name, date, time, partySize);

        assertThat(reservation.getName(), is(name));
    }
}