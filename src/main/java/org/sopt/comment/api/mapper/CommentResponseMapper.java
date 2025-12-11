package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.response.CommentCreateResponse;
import org.sopt.comment.application.dto.result.CommentCreateResult;

public class CommentResponseMapper {

    public static CommentCreateResponse toCreateResponse(
        CommentCreateResult commentCreateResult
    ) {
        return new CommentCreateResponse(
            commentCreateResult.commentId()
        );
    }
}
