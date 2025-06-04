package com.example.parkomat.repository.projection;

public interface DailyVehicleCountProjection {
    // These method names (and their return types) must match the aliases in your SQL SELECT clause.
    Long getReservationCount(); // Corresponds to count(r.reservation_id)
    String getType();           // Corresponds to pg.type
}