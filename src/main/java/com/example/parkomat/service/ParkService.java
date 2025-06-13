package com.example.parkomat.service;

import com.example.parkomat.dto.ParkRequestDto;
import com.example.parkomat.dto.ParkResponseDto;
import com.example.parkomat.model.Park;
import com.example.parkomat.repository.ParkRepository;
import com.example.parkomat.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkService {
    private final ParkRepository parkRepository;

    @Autowired
    public ParkService(ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    @Transactional(readOnly = true)
    public List<ParkResponseDto> getAllParks() {
        return parkRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ParkResponseDto getParkById(Long parkId) {
        Park park = parkRepository.findById(parkId)
                .orElseThrow(() -> new ResourceNotFoundException("Park", parkId));
        return convertToDto(park);
    }

    @Transactional
    public ParkResponseDto createPark(ParkRequestDto parkRequestDto) {
        Park park = new Park();
        // Mapowanie z Dto do Encji
        park.setName(parkRequestDto.getName());
        park.setLatitude(parkRequestDto.getLatitude());
        park.setLongitude(parkRequestDto.getLongitude());
        park.setParkLogoLink(parkRequestDto.getParkLogoLink());
        //park.setMapOutline(parkRequestDto.getMapOutline());

        Park savedPark = parkRepository.save(park);
        return convertToDto(savedPark);
    }

    @Transactional
    public ParkResponseDto updatePark(Long parkId, ParkRequestDto parkRequestDto) {
        Park existingPark = parkRepository.findById(parkId)
                .orElseThrow(() -> new ResourceNotFoundException("Park", parkId));

        // Aktualizuj pola istniejącego parku
        existingPark.setName(parkRequestDto.getName());
        existingPark.setLatitude(parkRequestDto.getLatitude());
        existingPark.setLongitude(parkRequestDto.getLongitude());
        existingPark.setParkLogoLink(parkRequestDto.getParkLogoLink());
        //existingPark.setMapOutline(parkRequestDto.getMapOutline());

        Park updatedPark = parkRepository.save(existingPark);
        return convertToDto(updatedPark);
    }

    @Transactional
    public void deletePark(Long parkId) {
        if (!parkRepository.existsById(parkId)) {
            throw new ResourceNotFoundException("Park", parkId);
        }
        parkRepository.deleteById(parkId);
    }

    // Prywatna metoda pomocnicza do konwersji Encji na Dto
    private ParkResponseDto convertToDto(Park park) {
        ParkResponseDto Dto = new ParkResponseDto();
        Dto.setId(park.getId());
        Dto.setName(park.getName());
        Dto.setLatitude(park.getLatitude());
        Dto.setLongitude(park.getLongitude());
        Dto.setParkLogoLink(park.getParkLogoLink());
        Dto.setParkSentence(park.getSentence());
        // Dto.setMapOutline(park.getMapOutline());
        return Dto;
    }
}