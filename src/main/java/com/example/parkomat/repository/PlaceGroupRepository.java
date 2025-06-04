// com.example.parkomat.repository.PlaceGroupRepository.java
package com.example.parkomat.repository;

import com.example.parkomat.model.PlaceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaceGroupRepository extends JpaRepository<PlaceGroup, Long> {
    // Metoda do znajdowania wszystkich grup miejsc dla danego parking_id
    List<PlaceGroup> findByParkingId(Long parkingId);
}