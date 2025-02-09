package com.insurance.VehicleInsurance.repository;

import com.insurance.VehicleInsurance.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
}
