package com.insurance.VehicleInsurance.service;

import com.insurance.VehicleInsurance.model.Member;
import com.insurance.VehicleInsurance.repository.MemberRepository;
import com.insurance.VehicleInsurance.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Member saveMember(Member member) { //  Changed from void to Member (Fix)
        return memberRepository.save(member);
    }


    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member with ID " + id + " not found")); //  Exception handling
    }


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

        return memberRepository.save(existingMember); //  Save and return updated member
    }


    public void deleteMember(Long id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Member with ID " + id + " not found"); //  Validation before deletion
        }
        memberRepository.deleteById(id);
    }
}
