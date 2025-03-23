package com.insurance.VehicleInsurance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "insurancepackage") // Matches MySQL table name
@Getter
@Setter
@NoArgsConstructor
public class InsurancePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PackageId")
    private Long packageId;

    @Column(name = "PackageName", nullable = false, length = 100)
    private String packageName;

    @Column(name = "Cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal cost;

    // One-to-Many with PurchasedPackage
    @OneToMany(mappedBy = "insurancePackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchasedPackage> purchasedPackages;

    // Many-to-Many with Policy through package_policy table
    @ManyToMany
    @JoinTable(
            name = "package_policy",
            joinColumns = @JoinColumn(name = "PackageId"),
            inverseJoinColumns = @JoinColumn(name = "PolicyId")
    )
    private Set<Policy> policies;

    public InsurancePackage(String packageName, BigDecimal cost) {
        this.packageName = packageName;
        this.cost = cost;
    }
}
