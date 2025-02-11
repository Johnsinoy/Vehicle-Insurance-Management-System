package com.insurance.VehicleInsurance.controller;

import com.insurance.VehicleInsurance.model.Member;
import com.insurance.VehicleInsurance.service.MemberService;
import com.insurance.VehicleInsurance.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member createMember(@Valid @RequestBody Member member) {
        return memberService.saveMember(member);
    }


    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @Valid @RequestBody Member memberDetails) {
        return memberService.updateMember(id, memberDetails); //  Call update method from service
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "Member with ID " + id + " has been deleted!";
    }
}
