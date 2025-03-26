package com.example.parkomat.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Parki")
@Entity
public class Park {
    @Id
    @Column(name = "park_id")
    private Long park_id;
    private String nazwa;
    @Column(name = "zarys_mapy")
    private String zarys_mapy;
    private String logo_parku_link;

    public void setId(Long park_id) {
        this.park_id = park_id;
    }

    public Long getId() {
        return park_id;
    }

    public void setPark_id(Long parkId) {
        this.park_id = parkId;
    }

    public Long getPark_id() {
        return park_id;
    }
}

