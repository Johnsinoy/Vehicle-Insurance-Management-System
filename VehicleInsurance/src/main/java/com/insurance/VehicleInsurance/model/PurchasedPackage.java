package com.insurance.VehicleInsurance.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "purchased_package")
@Getter
@Setter
@NoArgsConstructor
public class PurchasedPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Purchase_Id")
    private Long purchaseId;

    @ManyToOne
    @JoinColumn(name = "PackageId", nullable = false)
    private InsurancePackage insurancePackage;

    @ManyToOne
    @JoinColumn(name = "MemberId", nullable = false)
    private Member member;

    @Column(name = "Purchase_Date")
    private java.sql.Timestamp purchaseDate;
}
