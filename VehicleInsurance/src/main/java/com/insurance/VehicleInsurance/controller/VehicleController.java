package com.insurance.VehicleInsurance.controller;

import com.insurance.VehicleInsurance.model.Vehicle;
import com.insurance.VehicleInsurance.service.VehicleService;
import com.insurance.VehicleInsurance.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Retrieve all vehicles
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Retrieve a vehicle by ID or throw an exception if not found
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // Create a new vehicle with input validation
    @PostMapping
    public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    // Update an existing vehicle if found, else throw an exception
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @Valid @RequestBody Vehicle vehicleDetails) {
        return vehicleService.updateVehicle(id, vehicleDetails);
    }

    // Delete a vehicle by ID or throw an exception if not found
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "Vehicle with ID " + id + " has been deleted!";
    }

    // Handle validation errors for input fields
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }

    // Handle cases where the requested resource is not found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
}
