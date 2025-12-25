package org.sopt.member.application.service;

import static org.sopt.member.domain.exception.MemberErrorCode.MEMBER_NOT_FOUND;

import java.util.NoSuchElementException;
import org.sopt.member.application.port.in.MemberDeleteUseCase;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.port.out.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberDeleteService implements MemberDeleteUseCase {

    private final MemberRepository memberRepository;

    public MemberDeleteService(
        MemberRepository memberRepository
    ) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void deleteMember(Long memberId) {
        try {
            memberRepository.deleteById(memberId);
        } catch (NoSuchElementException e) {
            throw new MemberException(MEMBER_NOT_FOUND);
        }
    }
}
