package org.sopt.article.api.dto.response;

import java.util.List;

// TODO 단일 조회 dto에서 분리하기 (지금 쫌 바빠서 일단 이렇게)
public record ArticleFindAllResponse(
    List<ArticleFindOneResponse> articles
) {

}
