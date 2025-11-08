package org.sopt.article.api.mapper;

import org.sopt.article.api.dto.request.ArticleCreateRequest;
import org.sopt.article.application.dto.command.ArticleWriteCommand;
import org.sopt.article.domain.model.Tag;

public class ArticleRequestMapper {

    public static ArticleWriteCommand toArticleCreateCommand(
        Long memberId,
        ArticleCreateRequest articleCreateRequest
    ) {
        return new ArticleWriteCommand(
            memberId,
            Tag.valueOf(articleCreateRequest.tag()),
            articleCreateRequest.title(),
            articleCreateRequest.content()
        );
    }
}
