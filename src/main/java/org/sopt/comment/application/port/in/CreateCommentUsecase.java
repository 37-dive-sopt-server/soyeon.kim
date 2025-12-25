package org.sopt.comment.application.port.in;

import org.sopt.comment.application.dto.command.CreateCommentCommand;
import org.sopt.comment.application.dto.result.CreateCommentResult;

public interface CreateCommentUsecase {

    CreateCommentResult writeComment(CreateCommentCommand createCommentCommand);
}
