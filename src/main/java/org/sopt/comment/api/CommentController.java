package org.sopt.comment.api;

import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_CREATED_SUCCESS;
import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_DELETE_SUCCESS;
import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_LIST_RETRIEVED_SUCCESS;
import static org.sopt.comment.api.code.CommentSuccessCode.COMMENT_UPDATED_SUCCESS;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.comment.api.dto.request.CreateCommentRequest;
import org.sopt.comment.api.dto.request.UpdateCommentRequest;
import org.sopt.comment.api.dto.response.CreateCommentResponse;
import org.sopt.comment.api.dto.response.GetCommentListResponse;
import org.sopt.comment.api.dto.response.GetCommentMetaResponse;
import org.sopt.comment.api.dto.response.UpdateCommentResponse;
import org.sopt.comment.api.mapper.CommentRequestMapper;
import org.sopt.comment.api.mapper.CommentResponseMapper;
import org.sopt.comment.application.dto.command.CreateCommentCommand;
import org.sopt.comment.application.dto.command.UpdateCommentCommand;
import org.sopt.comment.application.dto.result.CreateCommentResult;
import org.sopt.comment.application.dto.result.GetCommentListResult;
import org.sopt.comment.application.dto.result.UpdateCommentResult;
import org.sopt.comment.application.port.in.CreateCommentUsecase;
import org.sopt.comment.application.port.in.DeleteCommentUsecase;
import org.sopt.comment.application.port.in.GetCommentListUsecase;
import org.sopt.comment.application.port.in.UpdateCommentUsecase;
import org.sopt.global.response.dto.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CreateCommentUsecase createCommentUsecase;
    private final UpdateCommentUsecase updateCommentUsecase;
    private final GetCommentListUsecase getCommentListUsecase;
    private final DeleteCommentUsecase deleteCommentUsecase;

    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<ApiResponseBody<CreateCommentResponse, Void>> createComment(
        @RequestHeader Long userId,
        @PathVariable Long articleId,
        @Valid @RequestBody CreateCommentRequest createCommentRequest
    ) {
        CreateCommentCommand createCommentCommand = CommentRequestMapper
            .toCommentCreateCommand(userId, articleId, createCommentRequest);
        CreateCommentResult commentCreateResult = createCommentUsecase
            .writeComment(createCommentCommand);
        CreateCommentResponse createCommentResponse = CommentResponseMapper
            .toCreateResponse(commentCreateResult);

        return ResponseEntity.status(CREATED)
            .body(ApiResponseBody.created(COMMENT_CREATED_SUCCESS, createCommentResponse));
    }

    @GetMapping("/articles/{articleId}/comments")
    public ResponseEntity<ApiResponseBody<GetCommentListResponse, GetCommentMetaResponse>> getCommentList(
        @PathVariable Long articleId,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        GetCommentListResult getCommentListResult = getCommentListUsecase
            .findByArticleId(articleId, page, size);
        GetCommentListResponse getCommentListResponse = CommentResponseMapper.toGetListResponse(
            getCommentListResult
        );
        GetCommentMetaResponse getCommentMetaResponse = GetCommentMetaResponse
            .create(getCommentListResult.getCommentMetaResult());

        return ResponseEntity.status(OK)
            .body(ApiResponseBody.ok(
                COMMENT_LIST_RETRIEVED_SUCCESS,
                getCommentListResponse,
                getCommentMetaResponse
            ));
    }

    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponseBody<UpdateCommentResponse, Void>> updateComment(
        @RequestHeader Long userId,
        @PathVariable Long commentId,
        @Valid @RequestBody UpdateCommentRequest updateCommentRequest
    ) {
        UpdateCommentCommand updateCommentCommand = CommentRequestMapper
            .toCommentUpdateCommand(userId, commentId, updateCommentRequest);
        UpdateCommentResult commentUpdateResult = updateCommentUsecase
            .updateComment(updateCommentCommand);
        UpdateCommentResponse updateCommentResponse = CommentResponseMapper
            .toUpdateResponse(commentUpdateResult);

        return ResponseEntity.status(OK)
            .body(ApiResponseBody.ok(COMMENT_UPDATED_SUCCESS, updateCommentResponse));
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponseBody<Void, Void>> deleteComment(
        @RequestHeader Long userId,
        @PathVariable Long commentId
    ) {
        deleteCommentUsecase.deleteComment(userId, commentId);

        return ResponseEntity.status(OK)
            .body(ApiResponseBody.ok(COMMENT_DELETE_SUCCESS));
    }

}
