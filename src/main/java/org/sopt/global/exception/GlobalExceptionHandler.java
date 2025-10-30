package org.sopt.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.sopt.global.response.ApiResponseBody;
import org.sopt.global.response.ErrorMeta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponseBody<Void, ErrorMeta>> handle(
        BusinessException e,
        HttpServletRequest request
    ) {
        ErrorCode errorCode = e.getErrorCode();

        System.err.println("===== HANDLED BUSINESS EXCEPTION =====");
        System.err.printf("[errorCode=%s] %s%n", errorCode.getCode(), e.getMessage());
        System.err.println("======================================");

        ErrorMeta meta = new ErrorMeta(
            request.getRequestURI(),
            System.currentTimeMillis()
        );

        return ResponseEntity.status(errorCode.getStatus())
            .body(ApiResponseBody.onFailure(errorCode, meta));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseBody<Void, ErrorMeta>> handle(
        Exception e,
        HttpServletRequest request
    ) {
        System.err.println("===== UNHANDLED EXCEPTION =====");
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.err.println("===============================");

        ErrorCode internalServerError = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorMeta meta = new ErrorMeta(
            request.getRequestURI(),
            System.currentTimeMillis()
        );

        return ResponseEntity.status(500)
            .body(ApiResponseBody.onFailure(internalServerError, e.getMessage(), meta));
    }
}
