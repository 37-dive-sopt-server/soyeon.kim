package org.sopt.comment.application.port.in;

import org.sopt.comment.application.dto.command.UpdateCommentCommand;
import org.sopt.comment.application.dto.result.UpdateCommentResult;

public interface UpdateCommentUsecase {

    UpdateCommentResult updateComment(UpdateCommentCommand updateCommentCommand);
}
