package org.sopt.member.api;

import java.util.List;
import java.util.Optional;
import org.sopt.member.api.dto.MemberCreateRequest;
import org.sopt.member.api.mapper.MemberRequestMapper;
import org.sopt.member.domain.model.Member;
import org.sopt.member.service.port.in.MemberService;
import org.sopt.member.service.MemberServiceImpl;
import org.sopt.member.service.dto.MemberJoinCommand;

public class MemberController {

    // TODO 유스케이스 별로 서비스 분리
    // TODO port, adapter 분리
    private final MemberService memberService = new MemberServiceImpl();

    // TODO response dto 추가
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

    public void deleteById(Long id) {
        memberService.deleteMember(id);
    }
}
