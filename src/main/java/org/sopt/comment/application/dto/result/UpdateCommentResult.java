package org.sopt.comment.application.dto.result;

import org.sopt.comment.domain.model.Comment;

public record UpdateCommentResult(
    Long commentId
) {

    public static UpdateCommentResult create(Comment comment) {
        return new UpdateCommentResult(comment.getId());
    }
}
