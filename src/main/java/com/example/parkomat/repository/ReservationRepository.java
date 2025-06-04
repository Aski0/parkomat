package com.example.parkomat.repository;


import com.example.parkomat.model.Reservation;
import com.example.parkomat.repository.projection.DailyVehicleCountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    @Query(value = "SELECT COUNT(r.reservation_id) AS reservationCount, pg.type AS type " +
            "FROM reservations r " +
            "JOIN place_groups pg ON r.parking_id = pg.parking_id AND r.typ = pg.type " +
            "WHERE r.parking_id = :parkingId " + // Filtr po parkingId
            "AND DATE(r.reservation_date) = DATE(:targetDate) " + // Filtr po konkretnej dacie
            "GROUP BY pg.type",
            nativeQuery = true)
    List<DailyVehicleCountProjection> countReservationsAndTypeByParkingIdAndDate(
            @Param("parkingId") Long parkingId, // Mapowanie parametru 'parkingId'
            @Param("targetDate") LocalDate targetDate // Mapowanie parametru 'targetDate'
    );
    Long deleteByParkingCode(String code);

}
