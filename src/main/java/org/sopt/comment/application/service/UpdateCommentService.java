package org.sopt.comment.application.service;

import static org.sopt.comment.domain.exception.CommentErrorCode.COMMENT_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.comment.application.dto.command.UpdateCommentCommand;
import org.sopt.comment.application.dto.result.UpdateCommentResult;
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

    public UpdateCommentResult updateComment(UpdateCommentCommand updateCommentCommand) {
        Comment comment = commentRepository.findById(updateCommentCommand.commentId())
            .orElseThrow(() -> new CommentException(COMMENT_NOT_FOUND));
        comment.update(updateCommentCommand.userId(), updateCommentCommand.content());

        return UpdateCommentResult.create(comment);
    }
}
