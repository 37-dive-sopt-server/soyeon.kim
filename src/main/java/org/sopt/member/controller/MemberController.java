package org.sopt.member.controller;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.Member;
import org.sopt.member.service.MemberService;
import org.sopt.member.service.MemberServiceImpl;

public class MemberController {

    private MemberService memberService = new MemberServiceImpl();

    public Long createMember(String name) {
        return memberService.join(name);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberService.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }
}
