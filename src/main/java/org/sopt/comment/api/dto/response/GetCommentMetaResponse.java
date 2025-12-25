package org.sopt.comment.api.dto.response;

import org.sopt.comment.application.dto.result.GetCommentMetaResult;

public record GetCommentMetaResponse(
    int totalPages,
    long totalElements,
    int size,
    int number,
    boolean isFirst,
    boolean isLast
) {

    public static GetCommentMetaResponse create(GetCommentMetaResult getCommentMetaResult) {
        return new GetCommentMetaResponse(
            getCommentMetaResult.totalPages(),
            getCommentMetaResult.totalElements(),
            getCommentMetaResult.size(),
            getCommentMetaResult.number(),
            getCommentMetaResult.isFirst(),
            getCommentMetaResult.isLast()
        );
    }
}
