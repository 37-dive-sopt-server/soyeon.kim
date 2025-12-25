package org.sopt.comment.application.dto.result;

import org.sopt.comment.domain.model.Comment;

public record GetCommentContentResult(
    Long id,
    GetCommentAuthorResult author,
    String content
) {

    public static GetCommentContentResult create(Comment comment) {
        return new GetCommentContentResult(
            comment.getId(),
            GetCommentAuthorResult.create(comment.getAuthor()),
            comment.getContent()
        );
    }

}
