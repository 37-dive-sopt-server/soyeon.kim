package org.sopt.comment.api.dto.response;

import org.sopt.comment.application.dto.result.GetCommentContentResult;

public record GetCommentContentResponse(
    Long id,
    GetCommentAuthorResponse author,
    String content
) {

    public static GetCommentContentResponse create(
        GetCommentContentResult getCommentContentResult
    ) {
        return new GetCommentContentResponse(
            getCommentContentResult.id(),
            GetCommentAuthorResponse.create(getCommentContentResult.author()),
            getCommentContentResult.content()
        );
    }
}
