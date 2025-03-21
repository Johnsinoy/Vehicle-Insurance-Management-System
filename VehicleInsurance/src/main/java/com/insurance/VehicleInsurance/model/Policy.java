package com.insurance.VehicleInsurance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Entity
@Table(name = "policy")
@Getter
@Setter
@NoArgsConstructor
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PolicyId")
    private Long policyId;

    @Column(name = "PolicyName", nullable = false, length = 100)
    private String policyName;

    @ManyToMany(mappedBy = "policies")
    private Set<InsurancePackage> insurancePackages;
}
