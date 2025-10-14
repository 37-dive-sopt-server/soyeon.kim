package org.sopt.member.application.port.in;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.model.Member;

public interface MemberUsecase {

    Optional<Member> findOne(Long memberId);

    List<Member> findAllMembers();

    void deleteMember(Long memberId);
}
