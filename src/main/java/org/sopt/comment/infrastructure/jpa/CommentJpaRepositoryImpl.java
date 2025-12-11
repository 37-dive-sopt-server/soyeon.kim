package org.sopt.comment.infrastructure.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CommentJpaRepositoryImpl {

    private final CommentJpaRepository jpa;

}
