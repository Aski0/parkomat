package com.example.parkomat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceGroupsRequestDto {
    private String type;    // <--- Change from "typ" to "type"
    private int quantity;
}