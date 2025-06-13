package com.example.parkomat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceGroupDto {
    @JsonProperty("group_id")
    private Long id;
    private String type;   // String
    private Long quantity;
    private Double price;// Long

    public PlaceGroupDto() {}

    public PlaceGroupDto(Long id, String type, Long quantity, Double price) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }
}