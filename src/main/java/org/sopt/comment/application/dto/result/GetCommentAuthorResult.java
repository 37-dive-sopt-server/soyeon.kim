package org.sopt.comment.application.dto.result;

import org.sopt.member.domain.model.Member;

public record GetCommentAuthorResult(
    Long id,
    String name
) {

    public static GetCommentAuthorResult create(Member member) {
        return new GetCommentAuthorResult(
            member.getId(),
            member.getName()
        );
    }
}
