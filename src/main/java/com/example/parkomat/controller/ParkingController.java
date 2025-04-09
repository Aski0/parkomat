package com.example.parkomat.controller;

import com.example.parkomat.model.Parking;
import com.example.parkomat.service.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/parkings")
public class ParkingController {
    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<Parking> getParkings() {
        return parkingService.getAllParkings();
    }

    @GetMapping("/{id}")
    public Parking getParking(@PathVariable int id) {
        return parkingService.getParkingById(id);
    }

    @PostMapping
    public Parking createParking(@RequestBody Parking parking) {
        return parkingService.createParking(parking);
    }

    @PutMapping("/{id}")
    public Parking updateParking(@PathVariable int id, @RequestBody Parking parking) {
        return parkingService.updateParking(id, parking);
    }

    @DeleteMapping("/{id}")
    public void deleteParking(@PathVariable int id) {
        parkingService.deleteParking(id);
    }
}

