package org.sopt.comment.application.service;

import static org.sopt.comment.domain.exception.CommentErrorCode.COMMENT_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.comment.application.dto.command.CommentUpdateCommand;
import org.sopt.comment.application.dto.result.CommentUpdateResult;
import org.sopt.comment.application.port.in.UpdateCommentUsecase;
import org.sopt.comment.domain.exception.CommentException;
import org.sopt.comment.domain.model.Comment;
import org.sopt.comment.domain.port.out.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class UpdateCommentService implements UpdateCommentUsecase {

    private final CommentRepository commentRepository;

    public CommentUpdateResult updateComment(CommentUpdateCommand commentUpdateCommand) {
        Comment comment = commentRepository.findById(commentUpdateCommand.commentId())
            .orElseThrow(() -> new CommentException(COMMENT_NOT_FOUND));
        comment.update(commentUpdateCommand.userId(), commentUpdateCommand.content());

        return CommentUpdateResult.create(comment);
    }
}
