package org.sopt.article.application.dto.result;

import org.sopt.article.domain.model.Article;

public record ArticleFindOneResult(
    Long id,
    ArticleWriterResult author,
    String tag,
    String title,
    String content
) {

    public static ArticleFindOneResult from(Article article) {
        return new ArticleFindOneResult(
            article.getId(),
            ArticleWriterResult.from(article.getMember()),
            article.getTag().toString(),
            article.getTitle(),
            article.getContent()
        );
    }
}
