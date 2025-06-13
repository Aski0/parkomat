// src/main/java/com/example/parkomat/dto/ParkingResponseDTO.java
package com.example.parkomat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ParkingResponseDto {
    @JsonProperty("parking_id")
    private Long id;

    private String name;
    private Long managerId;
    private Long latitude;
    private Long longitude;
    private String imageUrl;
    private String address;

    @JsonProperty("park_id")
    private Long parkId;

    @JsonProperty("place_groups")
    private List<PlaceGroupDto> placeGroups;

    public ParkingResponseDto() {
    }
    public ParkingResponseDto(Long id, String name, Long managerId, Long latitude,
                              Long longitude, Long parkId, String address,
                              String imageUrl, List<PlaceGroupDto> placeGroups) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.parkId = parkId;
        this.address = address;
        this.imageUrl = imageUrl;
        this.placeGroups = placeGroups;
    }
    // Gettery i Settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }
    public Long getLatitude() { return latitude; }
    public void setLatitude(Long latitude) { this.latitude = latitude; }
    public Long getLongitude() { return longitude; }
    public void setLongitude(Long longitude) { this.longitude = longitude; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
    public List<PlaceGroupDto> getPlaceGroups() {
        return placeGroups != null ? placeGroups : List.of();
    }
    public void setPlaceGroups(List<PlaceGroupDto> placeGroups) {
        this.placeGroups = placeGroups;
    }
}