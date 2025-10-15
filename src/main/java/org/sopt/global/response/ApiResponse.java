package org.sopt.global.response;

import org.sopt.global.exception.ErrorCode;

// TODO 스프링 부트 도입 시 null인 필드 JSON에서 생략하는 어노테이션 추가하기
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

    public static <T>ApiResponse<T, Void> created(T data, String message) {
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

    @Override
    public T data() {
        return data;
    }
}
