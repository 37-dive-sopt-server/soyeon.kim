package org.sopt.member.application.service;

import static org.sopt.global.exception.ErrorCode.MEMBER_BY_EMAIL_ALREADY_EXISTS;

import org.sopt.member.application.dto.command.MemberJoinCommand;
import org.sopt.member.application.dto.result.MemberJoinResult;
import org.sopt.member.application.port.in.MemberJoinUseCase;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;

public class MemberJoinService implements MemberJoinUseCase {

    private final MemberRepositoryPort memberRepository;

    public MemberJoinService(MemberRepositoryPort memberRepositoryPort) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public MemberJoinResult join(MemberJoinCommand memberJoinCommand) {
        if(memberRepository.existsByEmail(memberJoinCommand.email())) {
            throw new MemberException(MEMBER_BY_EMAIL_ALREADY_EXISTS);
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
