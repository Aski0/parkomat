package com.example.parkomat.controller;

import com.example.parkomat.dto.ParkingResponseDto; // Nadal używamy ParkingResponseDto
import com.example.parkomat.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ManagerController {

    private final ParkingService parkingService;

    @GetMapping("/{managerId}/parkings")
    public ResponseEntity<List<ParkingResponseDto>> getParkingsByManagerId(@PathVariable Long managerId) {
        // Wywołaj metodę w serwisie, która pobierze parkingi dla danego menadżera
        List<ParkingResponseDto> managerParkings = parkingService.getParkingsByManagerId(managerId);
        return ResponseEntity.ok(managerParkings);
    }

}