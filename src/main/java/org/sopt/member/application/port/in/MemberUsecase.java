package org.sopt.member.application.port.in;

import java.util.List;
import org.sopt.member.domain.model.Member;

public interface MemberUsecase {

    List<Member> findAllMembers();

    void deleteMember(Long memberId);
}
