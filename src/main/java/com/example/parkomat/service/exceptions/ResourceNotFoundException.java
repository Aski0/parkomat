// src/main/java/com/example/parkomat/service/exceptions/ResourceNotFoundException.java
package com.example.parkomat.service.exceptions;

// Nie potrzebujesz @ResponseStatus(HttpStatus.NOT_FOUND) jeśli używasz @ControllerAdvice
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceType, Long id) {
        super(String.format("%s not found with id: %d", resourceType, id));
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}