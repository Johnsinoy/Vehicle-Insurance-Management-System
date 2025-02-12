package com.insurance.VehicleInsurance.exception;

/**
 * Exception for handling cases where a requested resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
