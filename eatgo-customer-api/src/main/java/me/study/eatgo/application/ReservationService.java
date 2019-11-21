package me.study.eatgo.application;

import me.study.eatgo.domain.Reservation;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationService {
    public Reservation addReservation(Long restaurantId, Long userId, String name,
                                      String date, String time, Integer partySize) {
        return Reservation.builder()
                .restaurantId(restaurantId)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partySize)
                .build();
    }
}
