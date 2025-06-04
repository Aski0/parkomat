// com.example.parkomat.Dto.ParkingDetailsResponseDto.java
package com.example.parkomat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParkingDetailsResponseDto {
    @JsonProperty("parking_id")
    private Long id;
    private String name;
    private String address;
    private String imageUrl;
    private String description;
    private Long latitude;
    private Long longitude;

    @JsonProperty("park_id")
    private Long parkId;

    @JsonProperty("place_groups") // Nazwa pola w JSON
    private List<PlaceGroupDto> placeGroups; // NOWE POLE

    // ZMIANA TUTAJ: Użyj istniejącego ParkResponseDto
    private ParkResponseDto park;      // Informacje o parku
    private UserResponseDto manager;    // Informacje o managerze (User)

    // Konstruktory, Gettery, Settery
    public ParkingDetailsResponseDto() {}

    // Gettery i Settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getLatitude() { return latitude; }
    public void setLatitude(Long latitude) { this.latitude = latitude; }
    public Long getLongitude() { return longitude; }
    public void setLongitude(Long longitude) { this.longitude = longitude; }
    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
    public String getAddress() { return address; } // <--- GETTER
    public void setAddress(String address) { this.address = address; } // <--- SETTER
    // ZMIANA TUTAJ: Typ parametru i zwracany typ
    public ParkResponseDto getPark() { return park; }
    public void setPark(ParkResponseDto park) { this.park = park; }

    public UserResponseDto getManager() { return manager; }
    public void setManager(UserResponseDto manager) { this.manager = manager; }

    public List<PlaceGroupDto> getPlaceGroups() { return placeGroups; }
    public void setPlaceGroups(List<PlaceGroupDto> placeGroups) { this.placeGroups = placeGroups; }
}