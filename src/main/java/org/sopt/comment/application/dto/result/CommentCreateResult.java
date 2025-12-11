package org.sopt.comment.application.dto.result;

import org.sopt.comment.domain.model.Comment;

public record CommentCreateResult(
    Long commentId
) {

    public static CommentCreateResult create(Comment comment) {
        return new CommentCreateResult(comment.getId());
    }
}
