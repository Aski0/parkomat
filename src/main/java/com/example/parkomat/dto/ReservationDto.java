package com.example.parkomat.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {
    private Date reservationStartDate;
    private Date reservationEndDate;
    private String reserveEmail;
    private Long parkingId;
    private List<PlaceGroupsRequestDto> reservations;
}

