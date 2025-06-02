
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

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "parking_code")
    private Long parkingCode;

    @Column(name = "reserver_email")
    private String reserverEmail;

    @Column(name = "status")
    private Boolean status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public Date getReservationDate() { return reservationDate; }
    public void setReservationDate(Date reservationStartDate) { this.reservationDate = reservationStartDate; }

    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }

    public Long getParkingCode() { return parkingCode; }
    public void setParkingCode(Long parkingCode) { this.parkingCode = parkingCode; }

    public String getReserverEmail() { return reserverEmail; }
    public void setReserverEmail(String reserverEmail) { this.reserverEmail = reserverEmail; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
