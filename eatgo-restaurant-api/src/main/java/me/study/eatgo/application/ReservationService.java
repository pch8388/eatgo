package me.study.eatgo.application;

import me.study.eatgo.domain.Reservation;
import me.study.eatgo.domain.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Long restaurantId, Long userId, String name,
                                      String date, String time, Integer partySize) {
        Reservation reservation = Reservation.builder()
            .restaurantId(restaurantId)
            .userId(userId)
            .name(name)
            .date(date)
            .time(time)
            .partySize(partySize)
            .build();

        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations(Long restaurantId) {
        return reservationRepository.findAllByRestaurantId(restaurantId);
    }
}
