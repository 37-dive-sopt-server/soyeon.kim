package org.sopt.member.application.service;

import static org.sopt.global.exception.ErrorCode.MEMBER_NOT_FOUND;

import java.util.NoSuchElementException;
import org.sopt.member.application.port.in.MemberDeleteUseCase;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class MemberDeleteService implements MemberDeleteUseCase {

    private final MemberRepositoryPort memberRepository;

    public MemberDeleteService(MemberRepositoryPort memberRepositoryPort) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public void deleteMember(Long memberId) {
        try {
            memberRepository.deleteById(memberId);
        } catch(NoSuchElementException e) {
            throw new MemberException(MEMBER_NOT_FOUND);
        }
    }
}
