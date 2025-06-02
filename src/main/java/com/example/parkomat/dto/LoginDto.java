package com.example.parkomat.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Podaj poprawny adres email")
    @NotBlank(message = "Email nie może być pusty")
    private String email;

    @NotBlank(message = "Hasło nie może być puste")
    private String password;
}