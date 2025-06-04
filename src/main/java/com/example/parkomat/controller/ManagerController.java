// src/main/java/com/example/parkomat/controller/ManagerController.java
package com.example.parkomat.controller;

import com.example.parkomat.dto.ParkingResponseDto; // Nadal używamy ParkingResponseDto
import com.example.parkomat.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers") // Zmieniono ścieżkę na /api/managers
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ManagerController {

    private final ParkingService parkingService;

    @GetMapping("/{managerId}/parkings") // Zmieniono zmienną ścieżki na {managerId}
    public ResponseEntity<List<ParkingResponseDto>> getParkingsByManagerId(@PathVariable Long managerId) { // Zmieniono nazwę parametru
        // Wywołaj metodę w serwisie, która pobierze parkingi dla danego menadżera
        List<ParkingResponseDto> managerParkings = parkingService.getParkingsByManagerId(managerId); // Wywołanie nowej metody
        return ResponseEntity.ok(managerParkings);
    }

    // Możesz tu dodać inne endpointy związane z menadżerami, np. zarządzanie profilem, itp.
}