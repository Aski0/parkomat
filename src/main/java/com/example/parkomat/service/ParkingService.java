package com.example.parkomat.service;
import com.example.parkomat.model.Parking;
import com.example.parkomat.repository.ParkingRepository;
import com.example.parkomat.service.exceptions.ParkNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }

    public Parking getParkingById(long parkingId) {
        Optional<Parking> p = parkingRepository.findById(parkingId);

        return p.orElseThrow(() -> new ParkNotFoundException(parkingId));
    }
    public Parking createParking (Parking parking) {

        return parkingRepository.saveAndFlush(parking);
    }
    public Parking updateParking (long parkingId, Parking parking) {
        parking.setId(parkingId);

        return parkingRepository.saveAndFlush(parking);
    }
    public void deleteParking (long parkingId) {
        parkingRepository.deleteById(parkingId);
    }

}
