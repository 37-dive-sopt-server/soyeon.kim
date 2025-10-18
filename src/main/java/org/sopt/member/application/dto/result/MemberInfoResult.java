package org.sopt.member.application.dto.result;

import org.sopt.global.util.DateFormatUtil;
import org.sopt.member.domain.model.Member;

public record MemberInfoResult(
    Long id,
    String name,
    String birthday,
    String email,
    String gender
) {

    public static MemberInfoResult from(Member member) {
        return new MemberInfoResult(
            member.getId(),
            member.getName(),
            DateFormatUtil.format(member.getBirthday()),
            member.getEmail(),
            member.getGender().name()
        );
    }
}
