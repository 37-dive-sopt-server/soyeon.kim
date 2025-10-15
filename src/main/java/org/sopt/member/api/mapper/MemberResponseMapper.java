package org.sopt.member.api.mapper;

import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.api.dto.response.MemberFindOneResponse;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.dto.result.MemberJoinResult;

public class MemberResponseMapper {

    public static MemberCreateResponse toMemberCreateResponse(MemberJoinResult memberJoinResult) {
        return new MemberCreateResponse(memberJoinResult.id());
    }

    public static MemberFindOneResponse toMemberFindOneResponse(
        MemberFindOneResult memberFindOneResult
    ) {
        return new MemberFindOneResponse(
            memberFindOneResult.id(),
            memberFindOneResult.name(),
            memberFindOneResult.birthday(),
            memberFindOneResult.email(),
            memberFindOneResult.gender()
        );
    }
}
