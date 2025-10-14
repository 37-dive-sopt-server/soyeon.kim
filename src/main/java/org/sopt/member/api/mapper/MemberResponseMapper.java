package org.sopt.member.api.mapper;

import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.application.dto.result.MemberJoinResult;

public class MemberResponseMapper {

    public static MemberCreateResponse toMemberCreateResponse(MemberJoinResult memberJoinResult) {
        return new MemberCreateResponse(memberJoinResult.id());
    }
}
