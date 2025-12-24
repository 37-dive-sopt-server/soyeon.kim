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

    // 403 FORBIDDEN
    COMMENT_EDIT_FORBIDDEN(403, "COMMENT_403_001", "댓글 수정 권한이 없습니다."),

    // 404 NOT FOUND
    COMMENT_NOT_FOUND(404, "COMMENT_404_001", "해당 댓글이 존재하지 않습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}
