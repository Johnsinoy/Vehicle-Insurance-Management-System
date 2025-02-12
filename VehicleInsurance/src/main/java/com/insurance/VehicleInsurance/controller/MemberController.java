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

    // Retrieve all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // Retrieve a member by ID or throw an exception if not found
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    // Create a new member with input validation
    @PostMapping
    public Member createMember(@Valid @RequestBody Member member) {
        return memberService.saveMember(member);
    }

    // Update an existing member if found, else throw an exception
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @Valid @RequestBody Member memberDetails) {
        return memberService.updateMember(id, memberDetails);
    }

    // Delete a member by ID or throw an exception if not found
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "Member with ID " + id + " has been deleted!";
    }

    // Handle cases where the requested resource is not found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
}
