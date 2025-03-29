
package com.example.parkomat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Parks")
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "park_logo_link")
    private String parkLogoLink;

    @Column(name = "map_outline")
    private String mapOutline;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getParkLogoLink() { return parkLogoLink; }
    public void setParkLogoLink(String parkLogoLink) { this.parkLogoLink = parkLogoLink; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
