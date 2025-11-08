package org.sopt.member.application.service;

import java.util.List;
import org.sopt.member.application.dto.result.MemberListResult;
import org.sopt.member.application.port.in.MemberFindAllUseCase;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberFindAllService implements MemberFindAllUseCase {

    private final MemberRepositoryPort memberRepository;

    public MemberFindAllService(
        MemberRepositoryPort memberRepositoryPort
    ) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public MemberListResult findAllMembers() {
        List<Member> members = memberRepository.findAll();
        return MemberListResult.of(members);
    }
}
