package org.sopt.comment.infrastructure.jpa;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.article.domain.model.Article;
import org.sopt.comment.domain.model.Comment;
import org.sopt.comment.domain.port.out.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommentRepositoryAdapter implements CommentRepository {

    private final CommentJpaRepository jpa;

    @Override
    public void save(Comment comment) {
        jpa.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Page<Comment> findByArticle(Article article, Pageable pageable) {
        return jpa.findByArticle(article, pageable);
    }

}
