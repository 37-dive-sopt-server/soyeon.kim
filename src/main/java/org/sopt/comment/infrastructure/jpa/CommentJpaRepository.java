package org.sopt.comment.infrastructure.jpa;

import org.sopt.article.domain.model.Article;
import org.sopt.comment.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByArticle(Article article, Pageable pageable);
}
