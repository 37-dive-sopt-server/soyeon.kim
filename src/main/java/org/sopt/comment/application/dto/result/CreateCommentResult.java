package org.sopt.comment.application.dto.result;

import org.sopt.comment.domain.model.Comment;

public record CreateCommentResult(
    Long commentId
) {

    public static CreateCommentResult create(Comment comment) {
        return new CreateCommentResult(comment.getId());
    }
}
