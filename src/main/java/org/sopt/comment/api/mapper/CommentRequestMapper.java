package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.request.CommentCreateRequest;
import org.sopt.comment.api.dto.request.CommentUpdateRequest;
import org.sopt.comment.application.dto.command.CreateCommentCommand;
import org.sopt.comment.application.dto.command.UpdateCommentCommand;

public class CommentRequestMapper {

    public static CreateCommentCommand toCommentCreateCommand(
        Long userId,
        Long articleId,
        CommentCreateRequest commentCreateRequest
    ) {
        return new CreateCommentCommand(
            userId,
            articleId,
            commentCreateRequest.content()
        );
    }

    public static UpdateCommentCommand toCommentUpdateCommand(
        Long userId,
        Long articleId,
        CommentUpdateRequest commentUpdateRequest
    ) {
        return new UpdateCommentCommand(
            userId,
            articleId,
            commentUpdateRequest.content()
        );
    }

}
