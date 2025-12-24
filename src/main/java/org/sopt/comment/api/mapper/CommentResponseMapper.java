package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.response.CommentCreateResponse;
import org.sopt.comment.api.dto.response.CommentUpdateResponse;
import org.sopt.comment.application.dto.result.CreateCommentResult;
import org.sopt.comment.application.dto.result.UpdateCommentResult;

public class CommentResponseMapper {

    public static CommentCreateResponse toCreateResponse(
        CreateCommentResult commentCreateResult
    ) {
        return new CommentCreateResponse(commentCreateResult.commentId());
    }

    public static CommentUpdateResponse toUpdateResponse(
        UpdateCommentResult commentUpdateResult
    ) {
        return new CommentUpdateResponse(commentUpdateResult.commentId());
    }
}
