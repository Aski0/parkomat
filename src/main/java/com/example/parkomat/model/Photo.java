
package com.example.parkomat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    @Column(name = "photo_link")
    private String photoLink;

    @Column(name = "park_id")
    private Long parkId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhotoLink() { return photoLink; }
    public void setPhotoLink(String photoLink) { this.photoLink = photoLink; }

    public Long getParkId() { return parkId; }
    public void setParkId(Long parkId) { this.parkId = parkId; }
}
