package com.example.parkomat.service;
import com.example.parkomat.model.Reservation;
import com.example.parkomat.repository.ReservationRepository;
import com.example.parkomat.service.exceptions.ReservationNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(long reservationId) {
        Optional<Reservation> p = reservationRepository.findById(reservationId);

        return p.orElseThrow(() -> new ReservationNotFoundException(reservationId));
    }
    public Reservation createReservation (Reservation reservation) {

        return reservationRepository.saveAndFlush(reservation);
    }
    public Reservation updateReservation (long reservationId, Reservation reservation) {
        reservation.setId(reservationId);

        return reservationRepository.saveAndFlush(reservation);
    }
    public void deleteReservation (long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

}
