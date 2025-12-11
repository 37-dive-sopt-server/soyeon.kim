package org.sopt.comment.application.port.in;

import org.sopt.comment.application.dto.command.CommentCreateCommand;
import org.sopt.comment.application.dto.result.CommentCreateResult;

public interface CommentCreateUsecase {

    CommentCreateResult writeComment(CommentCreateCommand commentCreateCommand);
}
