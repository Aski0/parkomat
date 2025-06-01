// src/main/java/com/example/parkomat/controller/ParkController.java
package com.example.parkomat.controller;

import com.example.parkomat.dto.ParkRequestDto;
import com.example.parkomat.dto.ParkResponseDto;
import com.example.parkomat.dto.ParkingResponseDto; // Do nowego endpointu
import com.example.parkomat.service.ParkService;
import com.example.parkomat.service.ParkingService; // Do nowego endpointu
import jakarta.validation.Valid; // Dla walidacji
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parks")
@CrossOrigin(origins = "http://localhost:3000") // Dostosuj w razie potrzeby
public class ParkController {
    private final ParkService parkService;
    private final ParkingService parkingService; // Dodane dla endpointu z parkingami

    @Autowired
    public ParkController(ParkService parkService, ParkingService parkingService) {
        this.parkService = parkService;
        this.parkingService = parkingService;
    }

    @GetMapping
    public ResponseEntity<List<ParkResponseDto>> getAllParks() {
        return ResponseEntity.ok(parkService.getAllParks());
    }

    @GetMapping("/{parkId}") // Zmieniono id na parkId dla spójności, typ na Long
    public ResponseEntity<ParkResponseDto> getParkById(@PathVariable Long parkId) {
        return ResponseEntity.ok(parkService.getParkById(parkId));
    }

    // NOWY ENDPOINT: Pobieranie parkingów dla konkretnego parku
    @GetMapping("/{parkId}/parkings")
    public ResponseEntity<List<ParkingResponseDto>> getParkingsForPark(@PathVariable Long parkId) {
        return ResponseEntity.ok(parkingService.getParkingsByParkId(parkId));
    }

    @PostMapping
    public ResponseEntity<ParkResponseDto> createPark(@Valid @RequestBody ParkRequestDto parkRequestDto) {
        ParkResponseDto createdPark = parkService.createPark(parkRequestDto);
        return new ResponseEntity<>(createdPark, HttpStatus.CREATED);
    }

    @PutMapping("/{parkId}") // Zmieniono id na parkId, typ na Long
    public ResponseEntity<ParkResponseDto> updatePark(@PathVariable Long parkId,
                                                      @Valid @RequestBody ParkRequestDto parkRequestDto) {
        return ResponseEntity.ok(parkService.updatePark(parkId, parkRequestDto));
    }

    @DeleteMapping("/{parkId}") // Zmieniono id na parkId, typ na Long
    public ResponseEntity<Void> deletePark(@PathVariable Long parkId) {
        parkService.deletePark(parkId);
        return ResponseEntity.noContent().build(); // Standardowa odpowiedź dla DELETE
    }
}