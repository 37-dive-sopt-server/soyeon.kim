package org.sopt.comment.api.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum CommentSuccessCode implements SuccessCode {

    // 200 OK
    COMMENT_UPDATED_SUCCESS(200, "COMMENT_200_001", "성공적으로 댓글을 수정했습니다."),
    COMMENT_LIST_RETRIEVED_SUCCESS(200, "COMMENT_200_002", "성공적으로 해당 게시물의 댓글 목록을 조회했습니다."),

    // 201 CREATED
    COMMENT_CREATED_SUCCESS(201, "COMMENT_201_001", "성공적으로 댓글을 작성했습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;

}
