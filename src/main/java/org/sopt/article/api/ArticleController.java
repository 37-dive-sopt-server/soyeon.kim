package org.sopt.article.api;

import static org.sopt.global.response.SuccessCode.ARTICLE_CREATED_SUCCESS;

import lombok.RequiredArgsConstructor;
import org.sopt.article.api.dto.request.ArticleCreateRequest;
import org.sopt.article.api.dto.response.ArticleCreateResponse;
import org.sopt.article.api.mapper.ArticleRequestMapper;
import org.sopt.article.api.mapper.ArticleResponseMapper;
import org.sopt.article.application.dto.command.ArticleWriteCommand;
import org.sopt.article.application.dto.result.ArticleCreateResult;
import org.sopt.article.application.port.in.ArticleWriteUsecase;
import org.sopt.global.response.ApiResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleWriteUsecase articleWriteUsecase;

    @PostMapping("/members/{memberId}/articles")
    public ResponseEntity<ApiResponseBody<ArticleCreateResponse, Void>> articleWrite(
        @PathVariable Long memberId,
        @RequestBody ArticleCreateRequest articleCreateRequest
    ) {
        ArticleWriteCommand articleWriteCommand = ArticleRequestMapper
            .toArticleCreateCommand(memberId, articleCreateRequest);
        ArticleCreateResult articleCreateResult = articleWriteUsecase
            .writeArticle(articleWriteCommand);
        ArticleCreateResponse articleCreateResponse = ArticleResponseMapper
            .toArticleCreateResponse(articleCreateResult);

        return ResponseEntity.status(ARTICLE_CREATED_SUCCESS.getStatus())
            .body(ApiResponseBody.created(ARTICLE_CREATED_SUCCESS, articleCreateResponse));
    }
}
