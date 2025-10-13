package org.sopt.member.service;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.Member;
import org.sopt.member.service.dto.MemberJoinCommand;

public interface MemberService {

    Long join(MemberJoinCommand memberJoinCommand);

    Optional<Member> findOne(Long memberId);

    List<Member> findAllMembers();

    void deleteMember(Long memberId);
}
