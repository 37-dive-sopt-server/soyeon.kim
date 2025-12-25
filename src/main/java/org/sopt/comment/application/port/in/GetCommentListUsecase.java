package org.sopt.comment.application.port.in;

import org.sopt.comment.application.dto.result.GetCommentListResult;

public interface GetCommentListUsecase {

    GetCommentListResult findByArticleId(Long articleId, int page, int size);
}
