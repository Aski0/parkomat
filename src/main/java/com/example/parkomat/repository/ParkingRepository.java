// src/main/java/com/example.parkomat.repository.ParkingRepository.java
package com.example.parkomat.repository;

import com.example.parkomat.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    List<Parking> findByManagerId(Long managerId);
    List<Parking> findByParkId(Long parkId);
}