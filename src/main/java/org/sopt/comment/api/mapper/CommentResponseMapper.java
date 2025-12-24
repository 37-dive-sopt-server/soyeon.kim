package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.response.CreateCommentResponse;
import org.sopt.comment.api.dto.response.UpdateCommentResponse;
import org.sopt.comment.application.dto.result.CreateCommentResult;
import org.sopt.comment.application.dto.result.UpdateCommentResult;

public class CommentResponseMapper {

    public static CreateCommentResponse toCreateResponse(
        CreateCommentResult commentCreateResult
    ) {
        return new CreateCommentResponse(commentCreateResult.commentId());
    }

    public static UpdateCommentResponse toUpdateResponse(
        UpdateCommentResult commentUpdateResult
    ) {
        return new UpdateCommentResponse(commentUpdateResult.commentId());
    }
}
