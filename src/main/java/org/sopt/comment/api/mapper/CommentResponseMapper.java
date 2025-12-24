package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.response.CommentCreateResponse;
import org.sopt.comment.api.dto.response.CommentUpdateResponse;
import org.sopt.comment.application.dto.result.CommentCreateResult;
import org.sopt.comment.application.dto.result.CommentUpdateResult;

public class CommentResponseMapper {

    public static CommentCreateResponse toCreateResponse(
        CommentCreateResult commentCreateResult
    ) {
        return new CommentCreateResponse(commentCreateResult.commentId());
    }

    public static CommentUpdateResponse toUpdateResponse(
        CommentUpdateResult commentUpdateResult
    ) {
        return new CommentUpdateResponse(commentUpdateResult.commentId());
    }
}
