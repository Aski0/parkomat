// src/main/java/com/example/parkomat/Dto/ParkRequestDto.java
package com.example.parkomat.dto;

import jakarta.validation.constraints.NotBlank; // Dla walidacji
import jakarta.validation.constraints.NotNull;  // Dla walidacji

public class ParkRequestDto {
    @NotBlank(message = "Park name cannot be blank")
    private String name;

    @NotNull(message = "Latitude cannot be null")
    private Double latitude;

    @NotNull(message = "Longitude cannot be null")
    private Double longitude;

    private String parkLogoLink; // Może być opcjonalny
    private String mapOutline;   // Może być opcjonalny

    // Gettery i Settery
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getParkLogoLink() { return parkLogoLink; }
    public void setParkLogoLink(String parkLogoLink) { this.parkLogoLink = parkLogoLink; }
    public String getMapOutline() { return mapOutline; }
    public void setMapOutline(String mapOutline) { this.mapOutline = mapOutline; }
}