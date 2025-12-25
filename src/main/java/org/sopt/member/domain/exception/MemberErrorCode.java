package org.sopt.member.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements ErrorCode {

    // 400 BAD REQUEST
    AGE_MUST_UPPER_THAN_20(400, "MEM_400_001", "20세 미만은 가입할 수 없습니다."),

    // 404 NOT FOUND
    MEMBER_NOT_FOUND(404, "MEM_404_001", "존재하지 않는 회원입니다."),

    // 409 CONFLICT
    MEMBER_BY_EMAIL_ALREADY_EXISTS(409, "MEM_409_001", "해당 이메일로 가입된 회원이 이미 존재합니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}
