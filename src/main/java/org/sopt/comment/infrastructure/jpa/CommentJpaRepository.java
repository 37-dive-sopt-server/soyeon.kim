package org.sopt.comment.infrastructure.jpa;

import org.sopt.comment.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {

}
