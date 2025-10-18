package org.sopt.member.api.mapper;

import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.api.dto.response.MemberFindOneResponse;
import org.sopt.member.api.dto.response.MemberInfoResponse;
import org.sopt.member.api.dto.response.MemberListResponse;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.dto.result.MemberInfoResult;
import org.sopt.member.application.dto.result.MemberJoinResult;
import org.sopt.member.application.dto.result.MemberListResult;

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

    public static MemberListResponse toMemberListResponse(MemberListResult memberListResult) {
        return new MemberListResponse(
            memberListResult.members().stream()
                .map(MemberResponseMapper::toMemberInfoResponse)
                .toList()
        );
    }

    private static MemberInfoResponse toMemberInfoResponse(MemberInfoResult memberInfoResult) {
        return new MemberInfoResponse(
            memberInfoResult.id(),
            memberInfoResult.name(),
            memberInfoResult.birthday(),
            memberInfoResult.email(),
            memberInfoResult.gender()
        );
    }
}
