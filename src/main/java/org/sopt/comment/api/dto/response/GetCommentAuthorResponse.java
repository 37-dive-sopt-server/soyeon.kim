package org.sopt.comment.api.dto.response;

import org.sopt.comment.application.dto.result.GetCommentAuthorResult;

public record GetCommentAuthorResponse(
    Long id,
    String name
) {

    public static GetCommentAuthorResponse create(GetCommentAuthorResult getCommentAuthorResult) {
        return new GetCommentAuthorResponse(
            getCommentAuthorResult.id(),
            getCommentAuthorResult.name()
        );
    }

}
