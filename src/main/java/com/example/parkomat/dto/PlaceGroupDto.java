// src/main/java/com/example/parkomat/dto/PlaceGroupDto.java
package com.example.parkomat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceGroupDto {
    @JsonProperty("group_id")
    private Long id;
    private String type;   // String
    private Long quantity; // Long

    public PlaceGroupDto() {}

    // Konstruktor oczekujący (Long, String, Long)
    public PlaceGroupDto(Long id, String type, Long quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    // Gettery i Settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
}