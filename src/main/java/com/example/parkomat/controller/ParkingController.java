// com.example.parkomat.controller.ParkingController.java
package com.example.parkomat.controller;

import com.example.parkomat.dto.ParkingDetailsResponseDto;
import com.example.parkomat.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parkings")
@CrossOrigin(origins = "http://localhost:3000") // Dostosuj do swojego frontendu
public class ParkingController {
    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    // Endpoint dla ParkingDetailsPage
    @GetMapping("/{parkingId}")
    public ResponseEntity<ParkingDetailsResponseDto> getParkingDetails(@PathVariable Long parkingId) {
        ParkingDetailsResponseDto parkingDetails = parkingService.getParkingDetailsById(parkingId);
        return ResponseEntity.ok(parkingDetails);
    }
}