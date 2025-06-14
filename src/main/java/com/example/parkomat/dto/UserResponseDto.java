// com.example.parkomat.Dto.UserResponseDto.java
package com.example.parkomat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

// Ten Dto będzie reprezentował Managera
public class UserResponseDto {
    @JsonProperty("manager_id") // Zgodnie z typem Manager w React i nazwą kolumny w User
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty("phoneNumber") // Na frontendzie chcesz phoneNumber
    private String phone;

    // Konstruktory, Gettery, Settery
    public UserResponseDto() {}

    public UserResponseDto(Long id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    // ... Gettery i Settery ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}