package org.sopt.member.application.dto.result;

import java.util.List;
import org.sopt.member.domain.model.Member;

public record MemberListResult(
    List<MemberInfoResult> members
) {

    public static MemberListResult of(List<Member> memberList) {
        return new MemberListResult(
            memberList.stream()
                .map(MemberInfoResult::from)
                .toList()
        );
    }
}
