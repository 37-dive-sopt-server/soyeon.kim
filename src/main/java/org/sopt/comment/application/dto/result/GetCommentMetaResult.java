package org.sopt.comment.application.dto.result;

import org.sopt.comment.domain.model.Comment;
import org.springframework.data.domain.Page;

public record GetCommentMetaResult(
    int totalPages,
    long totalElements,
    int size,
    int number,
    boolean isFirst,
    boolean isLast
) {

    public static GetCommentMetaResult create(Page<Comment> commentPage) {
        return new GetCommentMetaResult(
            commentPage.getTotalPages(),
            commentPage.getTotalElements(),
            commentPage.getSize(),
            commentPage.getNumber(),
            commentPage.isFirst(),
            commentPage.isLast()
        );
    }
}
