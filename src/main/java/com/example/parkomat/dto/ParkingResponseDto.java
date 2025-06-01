// src/main/java/com/example/parkomat/dto/ParkingResponseDTO.java
package com.example.parkomat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// Ten DTO będzie używany do odpowiedzi dla /api/parks/{parkId}/parkings
public class ParkingResponseDto {
    @JsonProperty("parking_id") // Mapuje to pole na "parking_id" w JSON (zgodnie z typem Parking w React)
    private Long id; // Nazwa pola w Javie

    private String name;
    // managerId nie jest bezpośrednio wyświetlany, ale może być przydatny
    private Long managerId;
    private Long latitude; // Typ Long, tak jak w encji
    private Long longitude; // Typ Long

    @JsonProperty("park_id") // Mapuje to pole na "park_id" w JSON
    private Long parkId; // Nazwa pola w Javie, pobrane z encji Parking.parkId

    // Konstruktory
    public ParkingResponseDto() {
    }

    public ParkingResponseDto(Long id, String name, Long managerId, Long latitude, Long longitude, Long parkId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.parkId = parkId;
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
    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
}