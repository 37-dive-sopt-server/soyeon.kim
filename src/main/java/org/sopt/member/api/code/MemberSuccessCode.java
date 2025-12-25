package org.sopt.member.api.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum MemberSuccessCode implements SuccessCode {

    // 200 OK
    MEMBER_RETRIEVED_SUCCESS(200, "MEM_200_001", "특정 회원 조회가 성공적으로 완료되었습니다."),
    MEMBER_LIST_RETRIEVED_SUCCESS(200, "MEM_200_002","회원 전체 조회가 성공적으로 완료되었습니다."),
    MEMBER_DELETED_SUCCESS(200, "MEM_200_003","회원 삭제가 성공적으로 완료되었습니다."),

    // 201 CREATED
    MEMBER_CREATED_SUCCESS(201, "MEM_201_001", "회원가입이 성공적으로 완료되었습니다."),
    ;

    private final int status;
    private final String code;
    private final String message;
}
