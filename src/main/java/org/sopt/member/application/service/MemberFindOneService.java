package org.sopt.member.application.service;

import static org.sopt.global.exception.ErrorCode.MEMBER_NOT_FOUND;

import java.util.Optional;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.port.in.MemberFindOneUseCase;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemberFindOneService implements MemberFindOneUseCase {

    private final MemberRepositoryPort memberRepository;

    public MemberFindOneService(
        @Qualifier("memoryMemberRepository") MemberRepositoryPort memberRepositoryPort
    ) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public MemberFindOneResult findOne(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty()) {
            throw new MemberException(MEMBER_NOT_FOUND);
        }
        return MemberFindOneResult.from(member.get());
    }
}
