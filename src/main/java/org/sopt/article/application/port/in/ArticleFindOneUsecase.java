package org.sopt.article.application.port.in;

import org.sopt.article.application.dto.result.ArticleFindOneResult;

public interface ArticleFindOneUsecase {

    ArticleFindOneResult articleFindById(Long id);
}
