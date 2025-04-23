package com.example.parkomat.controller;

import com.example.parkomat.model.Reservation;
import com.example.parkomat.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable int id) {
        return reservationService.getReservationById(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }

}

