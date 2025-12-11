package org.sopt.comment.infrastructure.jpa;

import lombok.RequiredArgsConstructor;
import org.sopt.comment.domain.model.Comment;
import org.sopt.comment.domain.port.out.CommentRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommentRepositoryAdapter implements CommentRepository {

    private final CommentJpaRepository jpa;

    @Override
    public Comment save(Comment comment) {
        return jpa.save(comment);
    }

}
