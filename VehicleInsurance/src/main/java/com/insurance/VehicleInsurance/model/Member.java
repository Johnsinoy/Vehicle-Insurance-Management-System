package com.insurance.VehicleInsurance.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MemberID")
    private Long memberId;

    @NotNull(message = "First name cannot be null")
    @Size(min = 2, message = "First name must have at least 2 characters")
    @Column(name = "firstname")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 2, message = "Last name must have at least 2 characters")
    @Column(name = "lastname")
    private String lastName;

    @Email(message = "Invalid email format")
    @NotNull(message = "Email cannot be null")
    @Column(name = "Email")
    private String email;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Column(name = "Phone")
    private String phone;

    @NotNull(message = "Street address cannot be null")
    @Column(name = "Street")
    private String street;

    @NotNull(message = "City cannot be null")
    @Column(name = "City")
    private String city;

    @NotNull(message = "Province cannot be null")
    @Column(name = "Province")
    private String province;

    @NotNull(message = "Postal code cannot be null")
    @Pattern(regexp = "^[A-Za-z]\\d[A-Za-z] ?\\d[A-Za-z]\\d$", message = "Invalid postal code format")
    @Column(name = "Postal Code") // ✅ Fixed column name to avoid spaces
    private String postalCode;

    public Member() {}

    public Member(String firstName, String lastName, String email, String phone, String street, String city, String province, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    // Getters and Setters
    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }
}
