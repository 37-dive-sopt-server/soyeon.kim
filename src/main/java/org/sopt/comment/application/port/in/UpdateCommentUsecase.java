package org.sopt.comment.application.port.in;

import org.sopt.comment.application.dto.command.CommentUpdateCommand;
import org.sopt.comment.application.dto.result.CommentUpdateResult;

public interface UpdateCommentUsecase {

    CommentUpdateResult updateComment(CommentUpdateCommand commentUpdateCommand);
}
