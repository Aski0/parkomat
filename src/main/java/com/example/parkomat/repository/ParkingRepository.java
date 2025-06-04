// src/main/java/com/example.parkomat.repository.ParkingRepository.java
package com.example.parkomat.repository;

import com.example.parkomat.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    // Zmień FindByOwnerId na FindByManagerId, aby pasowało do pola w encji Parking
    List<Parking> findByManagerId(Long managerId); // Spring Data JPA znajdzie pole 'managerId'
    // lub metodę 'getManagerId()' w encji Parking.

    // Zachowaj inne istniejące metody
    List<Parking> findByParkId(Long parkId);
}