package org.sopt.article.application.port.in;

import org.sopt.article.application.dto.command.ArticleWriteCommand;
import org.sopt.article.application.dto.result.ArticleCreateResult;

public interface ArticleWriteUsecase {

     ArticleCreateResult writeArticle(ArticleWriteCommand articleWriteCommand);
}
