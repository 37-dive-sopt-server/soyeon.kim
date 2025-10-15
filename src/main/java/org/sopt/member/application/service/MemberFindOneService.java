package org.sopt.member.application.service;

import java.util.Optional;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.port.in.MemberFindOneUseCase;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;

public class MemberFindOneService implements MemberFindOneUseCase {

    private final MemberRepositoryPort memberRepository;

    public MemberFindOneService(MemberRepositoryPort memberRepositoryPort) {
        this.memberRepository = memberRepositoryPort;
    }

    @Override
    public MemberFindOneResult findOne(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isEmpty()) {
            throw new RuntimeException("존재하지 않는 회원입니다.");
        }
        return MemberFindOneResult.from(member.get());
    }
}
