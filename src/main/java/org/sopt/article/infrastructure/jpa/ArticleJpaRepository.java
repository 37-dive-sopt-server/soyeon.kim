package org.sopt.article.infrastructure.jpa;

import org.sopt.article.domain.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaRepository extends JpaRepository<Article, Long> {

    boolean existsByTitle(String title);

}
