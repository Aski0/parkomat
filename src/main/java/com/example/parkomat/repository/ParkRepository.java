//repository Park Repository
package com.example.parkomat.repository;

import com.example.parkomat.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Long> {

}

