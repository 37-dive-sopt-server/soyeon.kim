package org.sopt.global.response.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.global.exception.ErrorCode;
import org.sopt.global.response.code.SuccessCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponseBody<T, M>(
    boolean success,
    int status,
    String code,
    String message,
    T data,
    M meta
) {

    public static ApiResponseBody<Void, Void> ok(SuccessCode successCode) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getCode(),
            successCode.getMessage(),
            null,
            null
        );
    }

    public static <T> ApiResponseBody<T, Void> ok(SuccessCode successCode, T data) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getCode(),
            successCode.getMessage(),
            data,
            null
        );
    }

    public static <T, M> ApiResponseBody<T, M> ok(SuccessCode successCode, T data, M meta) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getCode(),
            successCode.getMessage(),
            data,
            meta
        );
    }

    public static <T> ApiResponseBody<T, Void> created(SuccessCode successCode, T data) {
        return new ApiResponseBody<>(
            true,
            successCode.getStatus(),
            successCode.getCode(),
            successCode.getMessage(),
            data,
            null
        );
    }

    public static ApiResponseBody<Void, ErrorMeta> onFailure(
        ErrorCode errorCode,
        ErrorMeta errorMeta
    ) {
        return new ApiResponseBody<>(
            false,
            errorCode.getStatus(),
            errorCode.getMessage(),
            errorCode.getCode(),
            null,
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
            errorCode.getCode(),
            message,
            null,
            errorMeta
        );
    }

    @Override
    public T data() {
        return data;
    }
}
