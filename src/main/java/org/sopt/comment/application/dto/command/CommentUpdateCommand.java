package org.sopt.comment.application.dto.command;

public record CommentUpdateCommand(
    Long userId,
    Long commentId,
    String content
) {

}
