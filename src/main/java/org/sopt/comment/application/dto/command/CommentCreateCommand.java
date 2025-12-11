package org.sopt.comment.application.dto.command;

public record CommentCreateCommand(
    Long userId,
    Long articleId,
    String content
) {

}
