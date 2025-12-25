package org.sopt.comment.application.dto.command;

public record UpdateCommentCommand(
    Long userId,
    Long commentId,
    String content
) {

}
