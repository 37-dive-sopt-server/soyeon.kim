package org.sopt.comment.application.port.in;

import org.sopt.comment.application.dto.command.CommentCreateCommand;
import org.sopt.comment.application.dto.result.CommentCreateResult;

public interface CreateCommentUsecase {

    CommentCreateResult writeComment(CommentCreateCommand commentCreateCommand);
}
