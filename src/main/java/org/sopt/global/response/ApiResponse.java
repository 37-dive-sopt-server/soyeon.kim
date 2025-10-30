package org.sopt.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.global.exception.ErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T, M>(
    boolean success,
    int status,
    String message,
    T data,
    String code,
    M meta
) {

    public static ApiResponse<Void, Void> ok(String message) {
        return new ApiResponse<>(true, 200, message, null, null, null);
    }

    public static <T> ApiResponse<T, Void> ok(T data, String message) {
        return new ApiResponse<>(true, 200, message, data, null, null);
    }

    public static <T> ApiResponse<T, Void> created(T data, String message) {
        return new ApiResponse<>(true, 201, message, data, null, null);
    }

    public static ApiResponse<Void, ErrorMeta> onFailure(ErrorCode errorCode, ErrorMeta errorMeta) {
        return new ApiResponse<>(
            false,
            errorCode.getStatus(),
            errorCode.getMessage(),
            null,
            errorCode.getCode(),
            errorMeta
        );
    }

    public static ApiResponse<Void, ErrorMeta> onFailure(
        ErrorCode errorCode,
        String message,
        ErrorMeta errorMeta
    ) {
        return new ApiResponse<>(
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
