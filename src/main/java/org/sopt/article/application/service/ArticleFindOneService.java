package org.sopt.article.application.service;

import static org.sopt.global.exception.ErrorCode.ARTICLE_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.article.application.dto.result.ArticleFindOneResult;
import org.sopt.article.application.port.in.ArticleFindOneUsecase;
import org.sopt.article.domain.exception.ArticleException;
import org.sopt.article.domain.model.Article;
import org.sopt.article.domain.port.out.ArticleRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleFindOneService implements ArticleFindOneUsecase {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleFindOneResult articleFindById(Long id) {
        Article article = articleRepository.findById(id)
            .orElseThrow(() -> new ArticleException(ARTICLE_NOT_FOUND));

        return ArticleFindOneResult.from(article);
    }
}
