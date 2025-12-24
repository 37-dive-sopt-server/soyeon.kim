package org.sopt.comment.application.dto.result;

import org.sopt.comment.domain.model.Comment;

public record CommentUpdateResult(
    Long commentId
) {

    public static CommentUpdateResult create(Comment comment) {
        return new CommentUpdateResult(comment.getId());
    }
}
