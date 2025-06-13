package com.example.parkomat.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceType, Long id) {
        super(String.format("%s not found with id: %d", resourceType, id));
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}