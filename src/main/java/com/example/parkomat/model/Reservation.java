
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

    @Column(name = "reservation_end_date")
    private Date reservationEndDate;

    @Column(name = "reservation_start_date")
    private Date reservationStartDate;

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

    public Date getReservationEndDate() { return reservationEndDate; }
    public void setReservationEndDate(Date reservationEndDate) { this.reservationEndDate = reservationEndDate; }

    public Date getReservationStartDate() { return reservationStartDate; }
    public void setReservationStartDate(Date reservationStartDate) { this.reservationStartDate = reservationStartDate; }

    public Long getGroupId() { return groupId; }
    public void setGroupId(Long groupId) { this.groupId = groupId; }

    public Long getParkingCode() { return parkingCode; }
    public void setParkingCode(Long parkingCode) { this.parkingCode = parkingCode; }

    public String getReserverEmail() { return reserverEmail; }
    public void setReserverEmail(String reserverEmail) { this.reserverEmail = reserverEmail; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
}
