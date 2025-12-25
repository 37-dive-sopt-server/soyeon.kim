package org.sopt.article.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.global.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum ArticleErrorCode implements ErrorCode {

    // 404 NOT FOUND
    ARTICLE_NOT_FOUND(404, "ART_404_001", "존재하지 않는 게시물입니다."),

    // 409 CONFLICT
    ARTICLE_BY_NAME_ALREADY_EXISTS(409, "ART_409_001", "해당 제목으로 작성된 게시글이 이미 존재합니다.");

    private final int status;
    private final String code;
    private final String message;

}
