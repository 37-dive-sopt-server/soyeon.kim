package org.sopt.member.controller;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.Member;
import org.sopt.member.service.MemberServiceImpl;

public class MemberController {

    private MemberServiceImpl memberServiceImpl = new MemberServiceImpl();

    public Long createMember(String name) {

        return memberServiceImpl.join(name);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberServiceImpl.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberServiceImpl.findAllMembers();
    }
}
