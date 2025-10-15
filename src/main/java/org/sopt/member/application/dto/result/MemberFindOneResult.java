package org.sopt.member.application.dto.result;

import org.sopt.global.util.DateFormatUtil;
import org.sopt.member.domain.model.Member;

public record MemberFindOneResult(
    Long id,
    String name,
    String birthday,
    String email,
    String gender
) {

    public static MemberFindOneResult from(Member member) {
        return new MemberFindOneResult(
            member.getId(),
            member.getName(),
            DateFormatUtil.format(member.getBirthday()),
            member.getEmail(),
            member.getGender().name()
        );
    }
}
