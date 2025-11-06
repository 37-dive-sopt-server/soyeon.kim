package org.sopt.article.api.dto.response;

public record ArticleFindOneResponse(
    Long id,
    ArticleWriterResponse author,
    String tag,
    String title,
    String content
) {

}
