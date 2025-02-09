package com.insurance.VehicleInsurance.controller;

import com.insurance.VehicleInsurance.model.Member;
import com.insurance.VehicleInsurance.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    // Retrieve all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Retrieve member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    // Create a new member
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        memberService.saveMember(member);
        return member;
    }

    // Update an existing member
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        Member member = memberService.getMemberById(id);
        if (member != null) {
            member.setFirstName(memberDetails.getFirstName());
            member.setLastName(memberDetails.getLastName());
            member.setEmail(memberDetails.getEmail());
            member.setPhone(memberDetails.getPhone());
            member.setStreet(memberDetails.getStreet());
            member.setCity(memberDetails.getCity());
            member.setProvince(memberDetails.getProvince());
            member.setPostalCode(memberDetails.getPostalCode());
            memberService.saveMember(member);
        }
        return member;
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "Member with ID " + id + " has been deleted!";
    }
}
