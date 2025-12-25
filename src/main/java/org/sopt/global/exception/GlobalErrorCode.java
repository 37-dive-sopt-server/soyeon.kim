package org.sopt.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {

    // 400 BAD REQUEST
    INVALID_NUMBER_FORMAT(400, "COM_400_001", "숫자만 입력해주세요."),
    INVALID_EMAIL_FORMAT(400, "COM_400_002", "잘못된 이메일 형식입니다."),
    INVALID_DATE_FORMAT(400, "COM_400_003", "잘못된 날짜 형식입니다."),
    INVALID_NULL_DATA(400, "COM_400_004", "빈 값은 허용되지 않습니다."),
    INVALID_MAPPING_PARAMETER(400, "COM_400_005", "매핑할 수 없는 값입니다."),

    // 404 NOT FOUND
    RESOURCE_NOT_FOUND(404, "COM_404_001", "존재하지 않는 리소스입니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "COM_500_001", "서버 내부 오류가 발생했습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}
