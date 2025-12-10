package org.sopt.comment.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum CommentErrorCode implements ErrorCode {

    // 400 BAD REQUEST
    ARTICLE_REQUIRED(400, "COMMENT_400_001", "관련된 아티클이 필요합니다."),
    MEMBER_REQUIRED(400, "COMMENT_400_002", "댓글 작성자가 필요합니다."),
    CONTENT_REQUIRED(400, "COMMENT_400_003", "댓글 본문이 필요합니다."),
    CONTENT_TOO_LONG(400, "COMMENT_400_004", "댓글 본문 길이는 300자 이하여야 합니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}
