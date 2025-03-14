package com.insurance.VehicleInsurance.service;

import com.insurance.VehicleInsurance.exception.ResourceNotFoundException;
import com.insurance.VehicleInsurance.model.Member;
import com.insurance.VehicleInsurance.model.Vehicle;
import com.insurance.VehicleInsurance.repository.MemberRepository;
import com.insurance.VehicleInsurance.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, MemberRepository memberRepository) {
        this.vehicleRepository = vehicleRepository;
        this.memberRepository = memberRepository;
    }

    // Retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Save a new vehicle
    public Vehicle saveVehicle(Vehicle vehicle) {
        // Ensure the member exists in the database before saving the vehicle
        Long memberId = vehicle.getMember().getMemberId();
        Member existingMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + memberId + " not found"));

        vehicle.setMember(existingMember); // Assign the existing member
        return vehicleRepository.save(vehicle);
    }

    // Retrieve a vehicle by ID or throw an exception if not found
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with ID " + id + " not found"));
    }

    // Update an existing vehicle
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle with ID " + id + " not found"));

        // Check if the provided member exists
        Long memberId = vehicleDetails.getMember().getMemberId();
        Member existingMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + memberId + " not found"));

        existingVehicle.setMember(existingMember);
        existingVehicle.setPlateNumber(vehicleDetails.getPlateNumber());
        existingVehicle.setMake(vehicleDetails.getMake());
        existingVehicle.setModel(vehicleDetails.getModel());
        existingVehicle.setYear(vehicleDetails.getYear());
        existingVehicle.setColor(vehicleDetails.getColor());

        return vehicleRepository.save(existingVehicle);
    }

    // Delete a vehicle by ID or throw an exception if not found
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicle with ID " + id + " not found");
        }
        vehicleRepository.deleteById(id);
    }
}
