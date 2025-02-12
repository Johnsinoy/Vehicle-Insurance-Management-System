package com.insurance.VehicleInsurance.service;

import com.insurance.VehicleInsurance.model.Member;
import com.insurance.VehicleInsurance.repository.MemberRepository;
import com.insurance.VehicleInsurance.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    // Retrieve all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Save a new or updated member
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    // Retrieve a member by ID or throw an exception if not found
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));
    }

    // Update an existing member
    public Member updateMember(Long id, Member memberDetails) {
        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found"));

        existingMember.setFirstName(memberDetails.getFirstName());
        existingMember.setLastName(memberDetails.getLastName());
        existingMember.setEmail(memberDetails.getEmail());
        existingMember.setPhone(memberDetails.getPhone());
        existingMember.setStreet(memberDetails.getStreet());
        existingMember.setCity(memberDetails.getCity());
        existingMember.setProvince(memberDetails.getProvince());
        existingMember.setPostalCode(memberDetails.getPostalCode());

        return memberRepository.save(existingMember); // ✅ Returns updated member
    }

    // Delete a member by ID or throw an exception if not found
    public void deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member with ID " + id + " not found");
        }
        memberRepository.deleteById(id);
    }
}
