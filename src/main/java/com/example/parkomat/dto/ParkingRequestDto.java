package com.example.parkomat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ParkingRequestDto {
    @NotBlank(message = "Parking name cannot be blank")
    private String name;

    private Long managerId;

    @NotNull(message = "Latitude cannot be null")
    private Long latitude;

    @NotNull(message = "Longitude cannot be null")
    private Long longitude;

    @NotNull(message = "Park ID cannot be null for a parking lot")
    private Long parkId;     // ID parku, do którego ma być przypisany parking

    // Gettery i Settery
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }
    public Long getLatitude() { return latitude; }
    public void setLatitude(Long latitude) { this.latitude = latitude; }
    public Long getLongitude() { return longitude; }
    public void setLongitude(Long longitude) { this.longitude = longitude; }
    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
}