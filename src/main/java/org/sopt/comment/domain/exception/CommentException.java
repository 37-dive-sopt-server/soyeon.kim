package org.sopt.comment.domain.exception;

import org.sopt.global.exception.BusinessException;
import org.sopt.global.exception.ErrorCode;

public class CommentException extends BusinessException {

    public CommentException(ErrorCode errorCode) {
        super(errorCode);
    }
}
