
package com.example.parkomat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PlaceGroups")
public class PlaceGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column(name = "parking_id")
    private Long parkingId;

    @Column(name = "type")
    private String type;

    @Column(name = "quantity")
    private Long quantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getParkingId() { return parkingId; }
    public void setParkingId(Long parkingId) { this.parkingId = parkingId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }
}
