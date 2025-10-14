package org.sopt.global.exception;

public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    public BusinessException(ErrorCode erorCode) {
        super(erorCode.getMessage());
        this.errorCode = erorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
