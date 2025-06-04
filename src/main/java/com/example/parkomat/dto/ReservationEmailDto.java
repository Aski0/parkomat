package com.example.parkomat.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReservationEmailDto {
    private String parkingName;
    private String parkingAddress;
    private Map<Date, Map<String, Integer>> reservationsByDate;
    private String qrCodeBase64;
    private List<String> parkingCodes;

    // Getters and setters
    public String getParkingName() { return parkingName; }
    public void setParkingName(String parkingName) { this.parkingName = parkingName; }

    public String getParkingAddress() { return parkingAddress; }
    public void setParkingAddress(String parkingAddress) { this.parkingAddress = parkingAddress; }

    public Map<Date, Map<String, Integer>> getReservationsByDate() { return reservationsByDate; }
    public void setReservationsByDate(Map<Date, Map<String, Integer>> reservationsByDate) { this.reservationsByDate = reservationsByDate; }

    public String getQrCodeBase64() { return qrCodeBase64; }
    public void setQrCodeBase64(String qrCodeBase64) { this.qrCodeBase64 = qrCodeBase64; }

    public List<String> getParkingCodes() { return parkingCodes; }
    public void setParkingCodes(List<String> parkingCodes) { this.parkingCodes = parkingCodes; }
}