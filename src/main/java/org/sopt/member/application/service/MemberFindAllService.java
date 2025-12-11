package org.sopt.member.application.service;

import java.util.List;
import org.sopt.member.application.dto.result.MemberListResult;
import org.sopt.member.application.port.in.MemberFindAllUseCase;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberFindAllService implements MemberFindAllUseCase {

    private final MemberRepository memberRepository;

    public MemberFindAllService(
        MemberRepository memberRepository
    ) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberListResult findAllMembers() {
        List<Member> members = memberRepository.findAll();
        return MemberListResult.of(members);
    }
}
