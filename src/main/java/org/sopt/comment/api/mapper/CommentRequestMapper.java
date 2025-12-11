package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.request.CommentCreateRequest;
import org.sopt.comment.application.dto.command.CommentCreateCommand;

public class CommentRequestMapper {

    public static CommentCreateCommand toCommentCreateCommand(
        Long userId,
        Long articleId,
        CommentCreateRequest commentCreateRequest
    ) {
        return new CommentCreateCommand(
            userId,
            articleId,
            commentCreateRequest.content()
        );
    }
}
