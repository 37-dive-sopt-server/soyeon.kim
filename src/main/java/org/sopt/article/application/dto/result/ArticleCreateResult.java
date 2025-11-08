package org.sopt.article.application.dto.result;

import org.sopt.article.domain.model.Article;

public record ArticleCreateResult(Long id) {

    public static ArticleCreateResult from(Article article) {
        return new ArticleCreateResult(article.getId());
    }

}
