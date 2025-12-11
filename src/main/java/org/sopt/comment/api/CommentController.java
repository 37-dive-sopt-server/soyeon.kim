package org.sopt.comment.api;

import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_CREATED_SUCCESS;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.comment.api.dto.request.CommentCreateRequest;
import org.sopt.comment.api.dto.response.CommentCreateResponse;
import org.sopt.comment.api.mapper.CommentRequestMapper;
import org.sopt.comment.api.mapper.CommentResponseMapper;
import org.sopt.comment.application.dto.command.CommentCreateCommand;
import org.sopt.comment.application.dto.result.CommentCreateResult;
import org.sopt.comment.application.port.in.CommentCreateUsecase;
import org.sopt.global.response.dto.ApiResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentCreateUsecase commentCreateUsecase;

    @PostMapping("/articles/{articleId}/comments")
    public ApiResponseBody<CommentCreateResponse, Void> createComment(
        @RequestHeader Long userId,
        @PathVariable Long articleId,
        @Valid @RequestBody CommentCreateRequest commentCreateRequest
    ) {
        CommentCreateCommand commentCreateCommand = CommentRequestMapper
            .toCommentCreateCommand(userId, articleId, commentCreateRequest);
        CommentCreateResult commentCreateResult = commentCreateUsecase
            .writeComment(commentCreateCommand);
        CommentCreateResponse commentCreateResponse = CommentResponseMapper
            .toCreateResponse(commentCreateResult);

        return ApiResponseBody.created(COMMENT_CREATED_SUCCESS, commentCreateResponse);
    }

    // 수정

    // 삭제

    // 조회
}
