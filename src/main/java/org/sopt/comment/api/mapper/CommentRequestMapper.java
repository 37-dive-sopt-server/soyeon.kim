package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.request.CommentCreateRequest;
import org.sopt.comment.api.dto.request.CommentUpdateRequest;
import org.sopt.comment.application.dto.command.CommentCreateCommand;
import org.sopt.comment.application.dto.command.CommentUpdateCommand;

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

    public static CommentUpdateCommand toCommentUpdateCommand(
        Long userId,
        Long articleId,
        CommentUpdateRequest commentUpdateRequest
    ) {
        return new CommentUpdateCommand(
            userId,
            articleId,
            commentUpdateRequest.content()
        );
    }

}
