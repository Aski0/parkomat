package com.example.parkomat.repository;

import com.example.parkomat.model.Park;
import com.example.parkomat.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    Parking findByManagerId(Long managerId);
}

