package com.insurance.VehicleInsurance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for MySQL
    private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false) // Foreign key linking to Member table
    private Member member;

    @Column(name = "plateNumber", unique = true, nullable = false, length = 20)
    private String plateNumber;

    @Column(name = "make", length = 50)
    private String make; // Vehicle brand

    @Column(name = "model", length = 50)
    private String model; // Vehicle model

    @Column(name = "year")
    private Integer year; // Year of manufacture

    @Column(name = "color", length = 30)
    private String color; // Vehicle color

    @Column(name = "createdAt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(); // Auto-sets the timestamp

    // Default Constructor
    public Vehicle() {
    }

    // Getters and Setters
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}