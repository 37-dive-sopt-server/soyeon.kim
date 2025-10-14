package org.sopt.global.exception;

import org.sopt.global.response.ApiResponse;
import org.sopt.global.response.ErrorMeta;
import org.sopt.global.trace.TraceIdManager;

public class GlobalExceptionHandler {

    public static ApiResponse<Void, ErrorMeta> handle(BusinessException e) {
        ErrorCode errorCode = e.getErrorCode();

        ErrorMeta meta = new ErrorMeta(
            TraceIdManager.getTraceId(),
            "console-app", // TODO 추후 스프링 부트 도입 시 요청 경로로 변경
            System.currentTimeMillis()
        );

        return ApiResponse.onFailure(errorCode, meta);
    }

    public static ApiResponse<Void, ErrorMeta> handle(Exception e) {
        System.err.println("===== UNHANDLED EXCEPTION =====");
        System.err.printf("[traceId=%s]%n", TraceIdManager.getTraceId());
        System.err.println(e.getMessage());
        System.err.println("===============================");

        ErrorCode internalServerError = ErrorCode.INTERNAL_SERVER_ERROR;
        ErrorMeta meta = new ErrorMeta(
            TraceIdManager.getTraceId(),
            "console-app",
            System.currentTimeMillis()
        );
        return ApiResponse.onFailure(internalServerError, meta);
    }
}
