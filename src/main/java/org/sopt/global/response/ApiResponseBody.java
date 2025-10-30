package org.sopt.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.global.exception.ErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponseBody<T, M>(
    boolean success,
    int status,
    String message,
    T data,
    String code,
    M meta
) {

    public static ApiResponseBody<Void, Void> ok(SuccessCode successCode) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getMessage(),
            null,
            null,
            null
        );
    }

    public static <T> ApiResponseBody<T, Void> ok(SuccessCode successCode, T data) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getMessage(),
            data,
            null,
            null
        );
    }

    public static <T> ApiResponseBody<T, Void> created(SuccessCode successCode, T data) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getMessage(),
            data,
            null,
            null
        );
    }

    public static ApiResponseBody<Void, ErrorMeta> onFailure(ErrorCode errorCode, ErrorMeta errorMeta) {
        return new ApiResponseBody<>(
            false,
            errorCode.getStatus(),
            errorCode.getMessage(),
            null,
            errorCode.getCode(),
            errorMeta
        );
    }

    public static ApiResponseBody<Void, ErrorMeta> onFailure(
        ErrorCode errorCode,
        String message,
        ErrorMeta errorMeta
    ) {
        return new ApiResponseBody<>(
            false,
            errorCode.getStatus(),
            message,
            null,
            errorCode.getCode(),
            errorMeta
        );
    }

    @Override
    public T data() {
        return data;
    }
}
