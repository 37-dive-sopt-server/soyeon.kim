package org.sopt.global.response;

public enum SuccessCode {

    // 200 OK
    MEMBER_RETRIEVED_SUCCESS(200, "특정 회원 조회가 성공적으로 완료되었습니다."),
    MEMBER_LIST_RETRIEVED_SUCCESS(200, "회원 전체 조회가 성공적으로 완료되었습니다."),
    MEMBER_DELETED_SUCCESS(200, "회원 삭제가 성공적으로 완료되었습니다."),

    // 201 CREATED
    MEMBER_CREATED_SUCCESS(201, "회원가입이 성공적으로 완료되었습니다.");


    private final int status;
    private final String message;

    SuccessCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
