package org.sopt.comment.api;

import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_CREATED_SUCCESS;
import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_UPDATED_SUCCESS;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.comment.api.dto.request.CommentCreateRequest;
import org.sopt.comment.api.dto.request.CommentUpdateRequest;
import org.sopt.comment.api.dto.response.CommentCreateResponse;
import org.sopt.comment.api.dto.response.CommentUpdateResponse;
import org.sopt.comment.api.mapper.CommentRequestMapper;
import org.sopt.comment.api.mapper.CommentResponseMapper;
import org.sopt.comment.application.dto.command.CommentCreateCommand;
import org.sopt.comment.application.dto.command.CommentUpdateCommand;
import org.sopt.comment.application.dto.result.CommentCreateResult;
import org.sopt.comment.application.dto.result.CommentUpdateResult;
import org.sopt.comment.application.port.in.CreateCommentUsecase;
import org.sopt.comment.application.port.in.UpdateCommentUsecase;
import org.sopt.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    private final CreateCommentUsecase commentCreateUsecase;
    private final UpdateCommentUsecase commentUpdateUsecase;

    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<ApiResponseBody<CommentCreateResponse, Void>> createComment(
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

        return ResponseEntity.status(CREATED)
            .body(ApiResponseBody.created(COMMENT_CREATED_SUCCESS, commentCreateResponse));
    }

    // 조회
    @GetMapping("/articles/{articleId}")
    public ResponseEntity<ApiResponseBody<Void, Void>> getCommentList (
        @RequestHeader Long userId,
        @PathVariable Long articleId
    ) {
        return null;
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponseBody<CommentUpdateResponse, Void>> updateComment (
        @RequestHeader Long userId,
        @PathVariable Long commentId,
        @Valid @RequestBody CommentUpdateRequest commentUpdateRequest
    ) {
        CommentUpdateCommand commentUpdateCommand = CommentRequestMapper
            .toCommentUpdateCommand(userId, commentId, commentUpdateRequest);
        CommentUpdateResult commentUpdateResult = commentUpdateUsecase
            .updateComment(commentUpdateCommand);
        CommentUpdateResponse commentUpdateResponse = CommentResponseMapper
            .toUpdateResponse(commentUpdateResult);

        return ResponseEntity.status(OK)
            .body(ApiResponseBody.ok(COMMENT_UPDATED_SUCCESS, commentUpdateResponse));
    }

    // 삭제

}
