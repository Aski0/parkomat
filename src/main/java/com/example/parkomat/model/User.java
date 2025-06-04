
package com.example.parkomat.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Managers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "nip")
    private String nip;

    @Column(name = "account_number")
    private String accountNumber;


}
