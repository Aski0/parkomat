// src/main/java/com/example/parkomat/dto/ParkResponseDTO.java
package com.example.parkomat.dto;

// Ten DTO będzie używany do odpowiedzi dla /api/parks i /api/parks/{id}
public class ParkResponseDto {
    private Long id; // Zgodnie z frontendem (park.id)
    private String name;
    private Double latitude;
    private Double longitude;
    private String parkLogoLink; // Zgodnie z frontendem (park.parkLogoLink)
    private String sentence;
    // Możesz dodać mapOutline, jeśli jest potrzebny na liście lub stronie szczegółów
    // private String mapOutline;

    // Konstruktory
    public ParkResponseDto() {
    }

    public ParkResponseDto(Long id, String name, Double latitude, Double longitude, String parkLogoLink, String sentence) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.parkLogoLink = parkLogoLink;
        this.sentence = sentence;
    }

    // Gettery i Settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public String getParkLogoLink() { return parkLogoLink; }
    public void setParkLogoLink(String parkLogoLink) { this.parkLogoLink = parkLogoLink; }
    public void setParkSentence(String sentence) {this.sentence = sentence;}
    public String getSentence() { return sentence; }
}