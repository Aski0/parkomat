package com.example.parkomat.controller;

import com.example.parkomat.model.Park;
import com.example.parkomat.service.ParkService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/parks")
public class ParkController {
    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping
    public List<Park> getParks() {
        return parkService.getAllParks();
    }

    @GetMapping("/{id}")
    public Park getPark(@PathVariable int id) {
        return parkService.getParkById(id);
    }

    @PostMapping
    public Park createPark(@RequestBody Park park) {
        return parkService.createPark(park);
    }

    @PutMapping("/{id}")
    public Park updatePark(@PathVariable int id, @RequestBody Park park) {
        return parkService.updatePark(id, park);
    }

    @DeleteMapping("/{id}")
    public void deletePark(@PathVariable int id) {
        parkService.deletePark(id);
    }
}

