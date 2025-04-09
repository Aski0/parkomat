
package com.example.parkomat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ParkingLots")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "latitude",nullable = false)
    private Long latitude;

    @Column(name = "longitude",nullable = false)
    private Long longitude;

    @Column(name = "park_id")
    private Long parkId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }

    public Long getLatitude() { return latitude; }
    public void setLatitude(Long latitude) { this.latitude = latitude; }

    public Long getLongitude() { return longitude; }
    public void setLongitude(Long longitude) { this.longitude = longitude; }

    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
}
