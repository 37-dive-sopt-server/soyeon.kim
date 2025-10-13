package org.sopt.member.controller;

import java.util.List;
import java.util.Optional;
import org.sopt.member.controller.dto.MemberCreateRequest;
import org.sopt.member.controller.mapper.MemberRequestMapper;
import org.sopt.member.domain.Member;
import org.sopt.member.service.MemberService;
import org.sopt.member.service.MemberServiceImpl;
import org.sopt.member.service.dto.MemberJoinCommand;

public class MemberController {

    private final MemberService memberService = new MemberServiceImpl();

    public Long createMember(MemberCreateRequest createRequest) {
        MemberJoinCommand memberJoinCommand = MemberRequestMapper.toJoinCommand(createRequest);
        return memberService.join(memberJoinCommand);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberService.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }
}
