package org.sopt.member.application.service;

import java.util.List;
import java.util.Optional;
import org.sopt.member.application.port.in.MemberUsecase;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.sopt.member.infrastructure.MemoryMemberRepository;

public class MemberService implements MemberUsecase {

    private final MemberRepositoryPort memberRepository = new MemoryMemberRepository();

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
