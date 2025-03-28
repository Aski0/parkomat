package com.example.parkomat.controller;

import com.example.parkomat.model.Park;
import com.example.parkomat.service.ParkService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/parki")
@CrossOrigin(origins = "http://localhost:5174") // Jeśli frontend działa na porcie 3000
public class ParkController {
    private final ParkService parkService;

    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping
    public List<Park> getParks() {
        return parkService.getAllParks();
    }
}
