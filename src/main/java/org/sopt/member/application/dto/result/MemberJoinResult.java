package org.sopt.member.application.dto.result;

import org.sopt.member.domain.model.Member;

public record MemberJoinResult(Long id) {

    public static MemberJoinResult from(Member member) {
        return new MemberJoinResult(member.getId());
    }
}
