package com.example.parkomat.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Parki") // Musi pasować do nazwy tabeli w bazie
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id")
    private Long id;

    @Column(name = "nazwa", nullable = false)
    private String nazwa;

    @Column(name = "zarys_mapy")
    private String zarysMapy;

    @Column(name = "logo_parku_link")
    private String logoParcuLink;

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public String getZarysMapy() { return zarysMapy; }
    public void setZarysMapy(String zarysMapy) { this.zarysMapy = zarysMapy; }

    public String getLogoParcuLink() { return logoParcuLink; }
    public void setLogoParcuLink(String logoParcuLink) { this.logoParcuLink = logoParcuLink; }
}
