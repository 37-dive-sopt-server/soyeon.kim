package org.sopt.member.service;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.Member;

public interface MemberService {

    Long join(String name);

    Optional<Member> findOne(Long memberId);

    List<Member> findAllMembers();
}
