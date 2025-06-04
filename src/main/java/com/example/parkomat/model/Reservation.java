
package com.example.parkomat.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    @Column(name = "typ")
    private String typ;

    @Column(name = "parking_id")
    private Long parkingId;

    @Column(name = "parking_code", unique = true)
    private String parkingCode;

    @Column(name = "reserver_email")
    private String reserverEmail;

    @Column(name = "status")
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public Date getReservationDate() { return reservationDate; }
    public void setReservationDate(Date reservationStartDate) { this.reservationDate = reservationStartDate; }


    public String getReserverEmail() { return reserverEmail; }
    public void setReserverEmail(String reserverEmail) { this.reserverEmail = reserverEmail; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public String getParkingCode() {
        return parkingCode;
    }

    public void setParkingCode(String parkingCode) {
        this.parkingCode = parkingCode;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public void setParkingId(Long parkingId) {
        this.parkingId = parkingId;
    }
}
