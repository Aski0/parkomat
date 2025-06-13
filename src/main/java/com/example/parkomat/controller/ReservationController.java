package com.example.parkomat.controller;

import com.example.parkomat.dto.FreeSpotsDto;
import com.example.parkomat.dto.ReservationDto;
import com.example.parkomat.model.Reservation;
import com.example.parkomat.service.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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
    public List <Reservation> createReservation(@RequestBody ReservationDto reservation) {
       return reservationService.createReservations(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }
    @Transactional
    @DeleteMapping("/{code}")
    public void deleteReservation(@PathVariable String code) {
        reservationService.deleteReservation(code);
    }


    @GetMapping("/quantity/{id}")
    public List<FreeSpotsDto> getQuantity(
            @PathVariable long id,
            @RequestParam(name = "data", required = false) LocalDate date
    ) {
        if (date == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parametr 'data' (data rezerwacji) jest wymagany i musi być podany w formacie RRRR-MM-DD.");
        }

        return reservationService.countFreeSpots(id, date);
    }
}

