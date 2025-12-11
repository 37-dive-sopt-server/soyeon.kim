package org.sopt.article.infrastructure.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.article.domain.model.Article;
import org.sopt.article.domain.port.out.ArticleRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ArticleJpaRepositoryImpl implements ArticleRepository {

    private final ArticleJpaRepository jpa;

    @Override
    public Article save(Article article) {
        return jpa.save(article);
    }

    @Override
    public boolean existsByTitle(String title){
        return jpa.existsByTitle(title);
    }

    @Override
    public Optional<Article> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Article> findAll() {
        return jpa.findAll();
    }

}
