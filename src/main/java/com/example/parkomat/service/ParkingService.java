// src/main/java/com/example/parkomat/service/ParkingService.java
package com.example.parkomat.service;

import com.example.parkomat.dto.ParkResponseDto;
import com.example.parkomat.dto.ParkingDetailsResponseDto;
import com.example.parkomat.dto.ParkingResponseDto; // POTRZEBNY IMPORT dla listy parkingów
import com.example.parkomat.dto.PlaceGroupDto;
import com.example.parkomat.dto.UserResponseDto;
import com.example.parkomat.model.Park;
import com.example.parkomat.model.Parking;
import com.example.parkomat.model.PlaceGroup;
import com.example.parkomat.model.User;
import com.example.parkomat.repository.ParkRepository;
import com.example.parkomat.repository.ParkingRepository;
import com.example.parkomat.repository.PlaceGroupRepository;
import com.example.parkomat.repository.UserRepository;
import com.example.parkomat.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;
    private final ParkRepository parkRepository;
    private final UserRepository userRepository;
    private final PlaceGroupRepository placeGroupRepository;

    @Autowired
    public ParkingService(ParkingRepository parkingRepository,
                          ParkRepository parkRepository,
                          UserRepository userRepository,
                          PlaceGroupRepository placeGroupRepository) {
        this.parkingRepository = parkingRepository;
        this.parkRepository = parkRepository;
        this.userRepository = userRepository;
        this.placeGroupRepository = placeGroupRepository;
    }

    @Transactional(readOnly = true)
    public ParkingDetailsResponseDto getParkingDetailsById(Long parkingId) {
        Parking parking = parkingRepository.findById(parkingId)
                .orElseThrow(() -> new ResourceNotFoundException("Parking", parkingId));

        // Używaj małej litery dla nazwy zmiennej zgodnie z konwencją Java
        ParkingDetailsResponseDto dto = new ParkingDetailsResponseDto();

        dto.setId(parking.getId());
        dto.setName(parking.getName());
        dto.setImageUrl(parking.getImageUrl());
        dto.setDescription(parking.getDescription());
        dto.setLatitude(parking.getLatitude());
        dto.setLongitude(parking.getLongitude());
        dto.setParkId(parking.getParkId());

        if (parking.getParkId() != null) {
            Park parkEntity = parkRepository.findById(parking.getParkId()).orElse(null);
            if (parkEntity != null) {
                dto.setPark(new ParkResponseDto(
                        parkEntity.getId(),
                        parkEntity.getName(),
                        parkEntity.getLatitude(),
                        parkEntity.getLongitude(),
                        parkEntity.getParkLogoLink()
                ));
            }
        }

        if (parking.getManagerId() != null) {
            User managerEntity = userRepository.findById(parking.getManagerId()).orElse(null);
            if (managerEntity != null) {
                dto.setManager(new UserResponseDto(
                        managerEntity.getId(),
                        managerEntity.getFirstName(),
                        managerEntity.getLastName(),
                        managerEntity.getEmail(),
                        managerEntity.getPhone()
                ));
            }
        }

        List<PlaceGroup> placeGroupsForParking = placeGroupRepository.findByParkingId(parking.getId());
        if (placeGroupsForParking != null && !placeGroupsForParking.isEmpty()) {
            List<PlaceGroupDto> placeGroupDtos = placeGroupsForParking.stream()
                    .map(pg -> new PlaceGroupDto(
                            pg.getId(),
                            pg.getType(),
                            pg.getQuantity()
                    ))
                    .collect(Collectors.toList());
            dto.setPlaceGroups(placeGroupDtos);
        } else {
            dto.setPlaceGroups(List.of());
        }

        return dto;
    }

    // ========================================================================
    // === DODAJ TĘ METODĘ ===
    // ========================================================================
    @Transactional(readOnly = true)
    public List<ParkingResponseDto> getParkingsByParkId(Long parkId) {
        // Opcjonalnie: Sprawdź, czy park o danym ID istnieje
        if (!parkRepository.existsById(parkId)) {
            // Możesz rzucić wyjątek lub zwrócić pustą listę
            // throw new ResourceNotFoundException("Park with id " + parkId + " not found, cannot fetch parkings.");
            return List.of(); // Zwróć pustą listę, jeśli park nie istnieje
        }

        // Pobierz listę encji Parking z repozytorium
        // Upewnij się, że ParkingRepository ma metodę findByParkId(Long parkId)
        List<Parking> parkings = parkingRepository.findByParkId(parkId);

        // Zmapuj listę encji Parking na listę ParkingResponseDto
        return parkings.stream()
                .map(this::convertToParkingResponseDto) // Metoda pomocnicza do mapowania
                .collect(Collectors.toList());
    }
    // ========================================================================


    // ========================================================================
    // === DODAJ TĘ METODĘ POMOCNICZĄ (jeśli jeszcze jej nie masz) ===
    // Służy do mapowania encji Parking na DTO dla listy parkingów
    // ========================================================================
    private ParkingResponseDto convertToParkingResponseDto(Parking parking) {
        if (parking == null) {
            return null;
        }
        // Upewnij się, że masz zdefiniowaną klasę ParkingResponseDto
        // i że zawiera ona odpowiednie pola i settery.
        ParkingResponseDto dto = new ParkingResponseDto();
        dto.setId(parking.getId()); // parking_id
        dto.setName(parking.getName());
        dto.setLatitude(parking.getLatitude());
        dto.setLongitude(parking.getLongitude());
        // Ustaw inne pola, jeśli ParkingResponseDto ich wymaga, np.:
        // dto.setImageUrl(parking.getImageUrl()); // Jeśli chcesz zdjęcie w liście
        // dto.setParkId(parking.getParkId()); // Jeśli chcesz ID parku w liście
        dto.setImageUrl(parking.getImageUrl()); // <--- USTAW IMAGE URL
        dto.setAddress(parking.getAddress());   // <--- USTAW ADRES

        return dto;
    }
    // ========================================================================
}