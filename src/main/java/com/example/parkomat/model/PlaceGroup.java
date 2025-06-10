
package com.example.parkomat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Column(name = "price")
    private Double price;


}
