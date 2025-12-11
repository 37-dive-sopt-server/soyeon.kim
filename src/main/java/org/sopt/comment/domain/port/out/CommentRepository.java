package org.sopt.comment.domain.port.out;

import org.sopt.comment.domain.model.Comment;

public interface CommentRepository {

    Comment save(Comment comment);
}
