// src/main/java/com/example/parkomat/service/ParkingService.java
package com.example.parkomat.service;

import com.example.parkomat.dto.*;
import com.example.parkomat.model.*;
import com.example.parkomat.repository.*;
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

        ParkingDetailsResponseDto dto = new ParkingDetailsResponseDto();
        dto.setId(parking.getId());
        dto.setName(parking.getName());
        dto.setImageUrl(parking.getImageUrl());
        dto.setDescription(parking.getDescription());
        dto.setLatitude(parking.getLatitude());
        dto.setLongitude(parking.getLongitude());
        dto.setParkId(parking.getParkId());

        if (parking.getParkId() != null) {
            parkRepository.findById(parking.getParkId()).ifPresent(parkEntity ->
                    dto.setPark(new ParkResponseDto(
                            parkEntity.getId(),
                            parkEntity.getName(),
                            parkEntity.getLatitude(),
                            parkEntity.getLongitude(),
                            parkEntity.getParkLogoLink()
                    ))
            );
        }

        if (parking.getManagerId() != null) {
            userRepository.findById(parking.getManagerId()).ifPresent(managerEntity ->
                    dto.setManager(new UserResponseDto(
                            managerEntity.getId(),
                            managerEntity.getFirstName(),
                            managerEntity.getLastName(),
                            managerEntity.getEmail(),
                            managerEntity.getPhone()
                    ))
            );
        }

        List<PlaceGroup> placeGroups = placeGroupRepository.findByParkingId(parking.getId());
        dto.setPlaceGroups(placeGroups.stream()
                .map(pg -> new PlaceGroupDto(pg.getId(), pg.getType(), pg.getQuantity()))
                .collect(Collectors.toList()));

        return dto;
    }

    @Transactional(readOnly = true)
    public List<ParkingResponseDto> getParkingsByParkId(Long parkId) {
        if (!parkRepository.existsById(parkId)) {
            return List.of();
        }

        return parkingRepository.findByParkId(parkId).stream()
                .map(parking -> {
                    List<PlaceGroupDto> placeGroups = placeGroupRepository.findByParkingId(parking.getId())
                            .stream()
                            .map(pg -> new PlaceGroupDto(pg.getId(), pg.getType(), pg.getQuantity()))
                            .collect(Collectors.toList());

                    return new ParkingResponseDto(
                            parking.getId(),
                            parking.getName(),
                            parking.getManagerId(),
                            parking.getLatitude(),
                            parking.getLongitude(),
                            parking.getParkId(),
                            parking.getAddress(),
                            parking.getImageUrl(),
                            placeGroups  // Dodane placeGroups
                    );
                })
                .collect(Collectors.toList());
    }}