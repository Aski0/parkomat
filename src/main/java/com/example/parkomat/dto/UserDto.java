package com.example.parkomat.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Email jest wymagany")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Podaj poprawny adres email")
    @Size(max = 100, message = "Email nie może przekraczać 100 znaków")
    private String email;

    @NotBlank(message = "Imię jest wymagane")
    @Size(max = 50, message = "Imię nie może przekraczać 50 znaków")
    private String firstName;

    @NotBlank(message = "Nazwisko jest wymagane")
    @Size(max = 50, message = "Nazwisko nie może przekraczać 50 znaków")
    private String lastName;

    @NotBlank(message = "Hasło jest wymagane")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Hasło musi zawierać co najmniej jedną cyfrę, małą literę, dużą literę i znak specjalny"
    )
    private String password;

    @NotBlank(message = "Numer telefonu jest wymagany")
    @Size(min = 9, max = 15, message = "Numer telefonu musi mieć od 9 do 15 cyfr")
    @Pattern(regexp = "^[0-9]+$", message = "Numer telefonu może zawierać tylko cyfry")
    private String phone;

    @NotBlank(message = "NIP jest wymagany")
    @Size(min = 10, max = 10, message = "NIP musi składać się z dokładnie 10 cyfr")
    @Pattern(regexp = "^[0-9]+$", message = "NIP może zawierać tylko cyfry")
    private String nip;

    @NotBlank(message = "Numer konta jest wymagany")
    @Size(min = 26, max = 26, message = "Numer konta musi składać się z dokładnie 26 cyfr")
    @Pattern(regexp = "^[0-9]+$", message = "Numer konta może zawierać tylko cyfry")
    private String accountNumber;
}