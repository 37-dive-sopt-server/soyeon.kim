package org.sopt.global.response;

import lombok.Getter;

// TODO 도메인 별 분리 => 다음 주에 할게요
@Getter
public enum SuccessCode {

    // 200 OK
    MEMBER_RETRIEVED_SUCCESS(200, "특정 회원 조회가 성공적으로 완료되었습니다."),
    MEMBER_LIST_RETRIEVED_SUCCESS(200, "회원 전체 조회가 성공적으로 완료되었습니다."),
    MEMBER_DELETED_SUCCESS(200, "회원 삭제가 성공적으로 완료되었습니다."),
    ARTICLE_RETRIEVED_SUCCESS(200, "특정 게시글 조회를 성공적으로 완료했습니다."),
    ARTICLE_LIST_RETRIEVED_SUCCESS(200, "게시글 전체 조회가 성공적으로 완료되었습니다."),

    // 201 CREATED
    MEMBER_CREATED_SUCCESS(201, "회원가입이 성공적으로 완료되었습니다."),
    ARTICLE_CREATED_SUCCESS(201, "게시물이 성공적으로 생성되었습니다.");


    private final int status;
    private final String message;

    SuccessCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
