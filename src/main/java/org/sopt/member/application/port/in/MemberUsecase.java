package org.sopt.member.application.port.in;

import java.util.List;
import java.util.Optional;
import org.sopt.member.domain.model.Member;
import org.sopt.member.application.dto.command.MemberJoinCommand;

public interface MemberUsecase {

    Long join(MemberJoinCommand memberJoinCommand);

    Optional<Member> findOne(Long memberId);

    List<Member> findAllMembers();

    void deleteMember(Long memberId);
}
