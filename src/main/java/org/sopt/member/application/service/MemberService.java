package org.sopt.member.application.service;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.sopt.member.infrastructure.MemoryMemberRepository;
import org.sopt.member.application.dto.command.MemberJoinCommand;
import org.sopt.member.application.port.in.MemberUsecase;

public class MemberService implements MemberUsecase {

    private final MemberRepositoryPort memberRepository = new MemoryMemberRepository();

    @Override
    public Long join(MemberJoinCommand memberJoinCommand) {
        if(memberRepository.existsByEmail(memberJoinCommand.email())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        Member member = Member.of(
            memberJoinCommand.name(),
            memberJoinCommand.birthday(),
            memberJoinCommand.email(),
            memberJoinCommand.gender()
        );
        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
