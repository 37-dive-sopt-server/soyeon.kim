package org.sopt.article.api.dto.request;

public record ArticleCreateRequest(
    String tag,
    String title,
    String content
) {

}
