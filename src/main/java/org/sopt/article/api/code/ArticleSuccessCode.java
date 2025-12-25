package org.sopt.article.api.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sopt.global.response.code.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum ArticleSuccessCode implements SuccessCode {

    // 200 OK
    ARTICLE_RETRIEVED_SUCCESS(200, "ART_200_001", "특정 게시글 조회를 성공적으로 완료했습니다."),
    ARTICLE_LIST_RETRIEVED_SUCCESS(200, "ART_200_002", "게시글 전체 조회가 성공적으로 완료되었습니다."),

    // 201 CREATED
    ARTICLE_CREATED_SUCCESS(201, "ART_201_001", "게시물이 성공적으로 생성되었습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}
