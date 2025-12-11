package org.sopt.member.application.service;

import static org.sopt.member.domain.exception.MemberErrorCode.MEMBER_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.port.in.MemberFindOneUseCase;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberFindOneService implements MemberFindOneUseCase {

    private final MemberRepository memberRepository;

    @Override
    public MemberFindOneResult findOne(Long id) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));

        return MemberFindOneResult.from(member);
    }
}
