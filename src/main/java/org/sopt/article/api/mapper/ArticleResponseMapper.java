package org.sopt.article.api.mapper;

import org.sopt.article.api.dto.response.ArticleCreateResponse;
import org.sopt.article.api.dto.response.ArticleFindAllResponse;
import org.sopt.article.api.dto.response.ArticleFindOneResponse;
import org.sopt.article.api.dto.response.ArticleWriterResponse;
import org.sopt.article.application.dto.result.ArticleCreateResult;
import org.sopt.article.application.dto.result.ArticleFindAllResult;
import org.sopt.article.application.dto.result.ArticleFindOneResult;
import org.sopt.article.application.dto.result.ArticleWriterResult;

public class ArticleResponseMapper {

    public static ArticleCreateResponse toArticleCreateResponse(
        ArticleCreateResult articleCreateResult
    ) {
        return new ArticleCreateResponse(articleCreateResult.id());
    }

    public static ArticleFindOneResponse toArticleFindOneResponse (
        ArticleFindOneResult articleFindOneResult
    ) {
        return new ArticleFindOneResponse(
            articleFindOneResult.id(),
            ArticleResponseMapper.toArticleWriterResponse(articleFindOneResult.author()),
            articleFindOneResult.tag(),
            articleFindOneResult.title(),
            articleFindOneResult.content()
        );
    }

    private static ArticleWriterResponse toArticleWriterResponse(
        ArticleWriterResult articleWriterResult
    ) {
        return new ArticleWriterResponse(
            articleWriterResult.id(),
            articleWriterResult.name()
        );
    }

    public static ArticleFindAllResponse toArticleFindAllResponse(
        ArticleFindAllResult articleFindAllResult
    ) {
        return new ArticleFindAllResponse(
            articleFindAllResult.articles().stream()
                .map(ArticleResponseMapper::toArticleFindOneResponse)
                .toList()
        );
    }
}
