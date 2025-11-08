package org.sopt.article.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.article.application.dto.result.ArticleFindAllResult;
import org.sopt.article.application.dto.result.ArticleFindOneResult;
import org.sopt.article.application.port.in.ArticleFindAllUsecase;
import org.sopt.article.domain.port.out.ArticleRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleFindAllService implements ArticleFindAllUsecase{

    private final ArticleRepository articleRepository;

    public ArticleFindAllResult findArticleAll() {
        List<ArticleFindOneResult> articleFindOneResults = articleRepository.findAll().stream()
            .map(ArticleFindOneResult::from)
            .toList();

        return new ArticleFindAllResult(articleFindOneResults);
    }
}
