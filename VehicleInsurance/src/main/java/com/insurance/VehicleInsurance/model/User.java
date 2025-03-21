package com.insurance.VehicleInsurance.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private boolean enabled;

    public String getUsername() {
        return  username;
    }

    public String getPassword() {
        return  password;
    }

    public String getRole() {
        return role;
    }

    public boolean isEnabled() {
        return  enabled;
    }
}
