package com.example.parkomat.service;
import com.example.parkomat.model.Park;
import com.example.parkomat.repository.ParkRepository;
import com.example.parkomat.service.exceptions.ParkNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParkService {
    private final ParkRepository parkRepository;

    public ParkService(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    public List<Park> getAllParks() {
        return parkRepository.findAll();
    }

    public Park getParkById(long parkId) {
        Optional<Park> p = parkRepository.findById(parkId);

        return p.orElseThrow(() -> new ParkNotFoundException(parkId));
    }
    public Park createPark (Park park) {

        return parkRepository.saveAndFlush(park);
    }
    public Park updatePark (long parkId, Park park) {
        park.setId(parkId);

        return parkRepository.saveAndFlush(park);
    }
    public void deletePark (long parkId) {
       parkRepository.deleteById(parkId);
    }

}
