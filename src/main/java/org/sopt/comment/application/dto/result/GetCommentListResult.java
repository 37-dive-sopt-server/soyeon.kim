package org.sopt.comment.application.dto.result;

import java.util.List;
import org.sopt.comment.domain.model.Comment;
import org.springframework.data.domain.Page;

public record GetCommentListResult(
    List<GetCommentContentResult> getCommentContentResult,
    GetCommentMetaResult getCommentMetaResult
) {

    public static GetCommentListResult create(Page<Comment> commentPage) {
        return new GetCommentListResult(
            commentPage.getContent().stream()
                .map(GetCommentContentResult::create)
                .toList(),
            GetCommentMetaResult.create(commentPage)
        );
    }
}
