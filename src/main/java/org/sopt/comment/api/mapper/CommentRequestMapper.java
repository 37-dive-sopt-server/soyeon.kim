package org.sopt.comment.api.mapper;

import org.sopt.comment.api.dto.request.CreateCommentRequest;
import org.sopt.comment.api.dto.request.UpdateCommentRequest;
import org.sopt.comment.application.dto.command.CreateCommentCommand;
import org.sopt.comment.application.dto.command.UpdateCommentCommand;

public class CommentRequestMapper {

    public static CreateCommentCommand toCommentCreateCommand(
        Long userId,
        Long articleId,
        CreateCommentRequest createCommentRequest
    ) {
        return new CreateCommentCommand(
            userId,
            articleId,
            createCommentRequest.content()
        );
    }

    public static UpdateCommentCommand toCommentUpdateCommand(
        Long userId,
        Long articleId,
        UpdateCommentRequest updateCommentRequest
    ) {
        return new UpdateCommentCommand(
            userId,
            articleId,
            updateCommentRequest.content()
        );
    }

}
