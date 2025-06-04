package com.example.parkomat.service;

import com.example.parkomat.dto.PlaceGroupsRequestDto;
import com.example.parkomat.dto.ReservationDto;
import com.example.parkomat.model.Parking;
import com.example.parkomat.model.Reservation;
import com.example.parkomat.repository.ParkingRepository;
import com.example.parkomat.repository.ReservationRepository;
import com.example.parkomat.service.exceptions.ReservationNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final EmailService emailService;
    private final ParkingRepository parkingRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              EmailService emailService,
                              ParkingRepository parkingRepository) {
        this.reservationRepository = reservationRepository;
        this.emailService = emailService;
        this.parkingRepository = parkingRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(long reservationId) {
        Optional<Reservation> p = reservationRepository.findById(reservationId);

        return p.orElseThrow(() -> new ReservationNotFoundException(reservationId));
    }
    public List<Reservation> createReservations(ReservationDto reservationDto) {
        Date startDate = reservationDto.getReservationStartDate();
        Date endDate = reservationDto.getReservationEndDate();
        List<PlaceGroupsRequestDto> placeGroups = reservationDto.getReservations();
        List<Reservation> createdReservations = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);

        // Przechodzimy przez każdy dzień w zakresie dat
        while (!calendar.after(endCalendar)) {
            Date currentDate = calendar.getTime();

            // Dla każdej grupy miejsc w rezerwacji
            for (PlaceGroupsRequestDto group : placeGroups) {
                // Tworzymy tyle rezerwacji ile wynosi quantity
                for (int i = 0; i < group.getQuantity(); i++) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationDate(currentDate);
                    reservation.setParkingId(reservationDto.getParkingId()); // Możesz dostosować to do swoich potrzeb
                    reservation.setParkingCode(generateRandomParkingCode()); // Możesz dostosować to do swoich potrzeb
                    reservation.setReserverEmail(reservationDto.getReserveEmail()); // Możesz dostosować to do swoich potrzeb
                    reservation.setTyp(group.getTyp());
                    reservation.setStatus(true); // domyślnie aktywna rezerwacja

                    // Dodatkowe pole jeśli chcesz zapisać typ miejsca
                    // reservation.setPlaceType(group.getTyp());

                    Reservation savedReservation = reservationRepository.save(reservation);
                    createdReservations.add(savedReservation);
                }
            }
            calendar.add(Calendar.DATE, 1); // przejdź do następnego dnia
        }
        Parking parking = parkingRepository.findById(reservationDto.getParkingId())
                .orElseThrow(() -> new RuntimeException("Parking not found with id: " + reservationDto.getParkingId()));

        for (Reservation savedReservation : createdReservations) {
            // Send email with QR code for each reservation
            emailService.sendReservationEmail(
                    savedReservation.getReserverEmail(),
                    savedReservation.getParkingCode(),
                    parking.getName(),
                    parking.getAddress(),
                    savedReservation.getReservationDate()
            );
        }

        return createdReservations;
    }
    public Reservation updateReservation (long reservationId, Reservation reservation) {
        reservation.setId(reservationId);

        return reservationRepository.saveAndFlush(reservation);
    }
    public void deleteReservation (long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    private String generateRandomParkingCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            codeBuilder.append(chars.charAt(random.nextInt(chars.length())));
        }

        return codeBuilder.toString();
    }
}