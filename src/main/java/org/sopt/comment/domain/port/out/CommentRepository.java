package org.sopt.comment.domain.port.out;

import java.util.Optional;
import org.sopt.comment.domain.model.Comment;

public interface CommentRepository {

    void save(Comment comment);
    Optional<Comment> findById(Long id);
}
