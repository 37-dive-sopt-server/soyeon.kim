package org.sopt.article.api.mapper;

import org.sopt.article.api.dto.response.ArticleCreateResponse;
import org.sopt.article.application.dto.result.ArticleCreateResult;

public class ArticleResponseMapper {

    public static ArticleCreateResponse toArticleCreateResponse(
        ArticleCreateResult articleCreateResult
    ) {
        return new ArticleCreateResponse(articleCreateResult.id());
    }
}
