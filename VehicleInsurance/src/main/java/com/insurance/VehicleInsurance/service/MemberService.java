package com.insurance.VehicleInsurance.service;

import com.insurance.VehicleInsurance.model.Member;
import com.insurance.VehicleInsurance.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public Member getMemberById(Long id) {
        Optional<Member> optional = memberRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
