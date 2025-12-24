package org.sopt.comment.domain.port.out;

import java.util.Optional;
import org.sopt.article.domain.model.Article;
import org.sopt.comment.domain.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {

    void save(Comment comment);
    Optional<Comment> findById(Long id);
    Page<Comment> findByArticle(Article article, Pageable pageable);
}
