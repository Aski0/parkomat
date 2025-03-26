package com.example.parkomat.service;
import com.example.parkomat.model.Park;
import com.example.parkomat.repository.ParkRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ParkService {
    private final ParkRepository parkRepository;

    public ParkService(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    public List<Park> getAllParks() {
        return parkRepository.findAll();
    }
}
