package org.sopt.member.application.service;

import org.sopt.member.application.dto.command.MemberJoinCommand;
import org.sopt.member.application.dto.result.MemberJoinResult;
import org.sopt.member.application.port.in.MemberJoinUsecase;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;

public class MemberJoinService implements MemberJoinUsecase {

    private final MemberRepositoryPort memberRepository;

    public MemberJoinService(MemberRepositoryPort memberRepositoryPort) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public MemberJoinResult join(MemberJoinCommand memberJoinCommand) {
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

        return MemberJoinResult.from(savedMember);
    }
}
