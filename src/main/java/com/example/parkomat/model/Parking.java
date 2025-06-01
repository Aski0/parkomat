// com.example.parkomat.model.Parking.java
package com.example.parkomat.model;

import jakarta.persistence.*;
// import lombok.Getter; // Jeśli chcesz używać Lombok dla getterów/setterów
// import lombok.Setter;

// @Getter // Lombok
// @Setter // Lombok
@Entity
@Table(name = "ParkingLots") // Upewnij się, że to "parking_lots" jeśli tak jest w bazie
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url") // NOWE
    private String imageUrl;

    @Column(name = "description", columnDefinition = "TEXT") // NOWE
    private String description;

    @Column(name = "manager_id") // Klucz obcy do tabeli Managers (User)
    private Long managerId;

    @Column(name = "latitude", nullable = false)
    private Long latitude;

    @Column(name = "longitude", nullable = false)
    private Long longitude;

    @Column(name = "park_id") // Klucz obcy do tabeli Parks
    private Long parkId;

    // Konstruktor
    public Parking() {}

    // Gettery i Settery (jeśli nie używasz Lombok)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }
    public Long getLatitude() { return latitude; }
    public void setLatitude(Long latitude) { this.latitude = latitude; }
    public Long getLongitude() { return longitude; }
    public void setLongitude(Long longitude) { this.longitude = longitude; }
    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
}