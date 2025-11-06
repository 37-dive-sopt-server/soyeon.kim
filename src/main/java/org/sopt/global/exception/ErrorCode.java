package org.sopt.global.exception;

import lombok.Getter;

// TODO 도메인 별 분리 => 다음 주에 할게요
@Getter
public enum ErrorCode {

    // =================== COMMON ===================
    // 400 BAD REQUEST
    INVALID_NUMBER_FORMAT(400, "COM_001", "숫자만 입력해주세요."),
    INVALID_EMAIL_FORMAT(400, "COM_002", "잘못된 이메일 형식입니다."),
    INVALID_DATE_FORMAT(400, "COM_005", "잘못된 날짜 형식입니다."),
    INVALID_NULL_DATA(400, "COM_006", "빈 값은 허용되지 않습니다."),
    INVALID_MAPPING_PARAMETER(400, "COM_007", "매핑할 수 없는 값입니다."),

    // 404 NOT FOUND
    RESOURCE_NOT_FOUND(404, "COM_003", "존재하지 않는 리소스입니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, "COM_004", "서버 내부 오류가 발생했습니다."),

    // =================== COMMON ===================
    // 400 BAD REQUEST
    AGE_MUST_UPPER_THAN_20(400, "MEM_003", "20세 미만은 가입할 수 없습니다."),

    // 404 NOT FOUND
    MEMBER_NOT_FOUND(404, "MEM_001", "존재하지 않는 회원입니다."),
    ARTICLE_NOT_FOUND(404, "ART_001", "존재하지 않는 게시물입니다."),

    // 409 CONFLICT
    MEMBER_BY_EMAIL_ALREADY_EXISTS(409, "MEM_002", "해당 이메일로 가입된 회원이 이미 존재합니다."),
    ARTICLE_BY_NAME_ALREADY_EXISTS(409, "ART_002", "해당 제목으로 작성된 게시글이 이미 존재합니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
