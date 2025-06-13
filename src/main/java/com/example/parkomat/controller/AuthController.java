package com.example.parkomat.controller;

import com.example.parkomat.dto.LoginDto;
import com.example.parkomat.dto.UserDto;
import com.example.parkomat.model.User;
import com.example.parkomat.service.UserService;
import com.example.parkomat.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto dto) {
        try {
            User user = userService.login(dto);
            String token = jwtUtil.generateToken(user.getEmail());

            return ResponseEntity.ok(Map.of("token", token, "userId", user.getId()));
        } catch (UsernameNotFoundException | BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }
    }
}