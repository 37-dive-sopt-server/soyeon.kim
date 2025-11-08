package org.sopt.article.application.dto.result;

import java.util.List;

public record ArticleFindAllResult(
    List<ArticleFindOneResult> articles
) {

}
