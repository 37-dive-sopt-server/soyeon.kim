package org.sopt.member.application.service;

import org.sopt.member.application.port.in.MemberDeleteUsecase;
import org.sopt.member.domain.port.out.MemberRepositoryPort;

public class MemberDeleteService implements MemberDeleteUsecase {

    private final MemberRepositoryPort memberRepository;

    public MemberDeleteService(MemberRepositoryPort memberRepositoryPort) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
