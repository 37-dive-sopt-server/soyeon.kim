package org.sopt.comment.application.dto.command;

public record CreateCommentCommand(
    Long userId,
    Long articleId,
    String content
) {

}
