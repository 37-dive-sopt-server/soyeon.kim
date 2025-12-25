package org.sopt.comment.application.service;

import static org.sopt.comment.domain.exception.CommentErrorCode.COMMENT_DELETE_FORBIDDEN;
import static org.sopt.comment.domain.exception.CommentErrorCode.COMMENT_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.comment.application.port.in.DeleteCommentUsecase;
import org.sopt.comment.domain.exception.CommentException;
import org.sopt.comment.domain.model.Comment;
import org.sopt.comment.domain.port.out.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class DeleteCommentService implements DeleteCommentUsecase {

    private final CommentRepository commentRepository;

    @Override
    public void deleteComment(Long userId, Long commentId) {
        Comment comment = getExistingComment(commentId);
        validateCanDelete(userId, comment);
        commentRepository.deleteById(commentId);
    }

    private Comment getExistingComment(Long commentId) {
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new CommentException(COMMENT_NOT_FOUND));
    }

    private void validateCanDelete(Long userId, Comment comment) {
        if(!comment.isOwner(userId)) {
            throw new CommentException(COMMENT_DELETE_FORBIDDEN);
        }
    }

}
