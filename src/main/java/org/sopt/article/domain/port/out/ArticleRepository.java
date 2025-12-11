package org.sopt.article.domain.port.out;

import java.util.List;
import java.util.Optional;
import org.sopt.article.domain.model.Article;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository {

    Article save(Article article);
    boolean existsByTitle(String title);
    Optional<Article> findById(Long id);
    List<Article> findAll();
}
