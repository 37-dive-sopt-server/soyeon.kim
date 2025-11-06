package org.sopt.article.application.dto.command;

import org.sopt.article.domain.model.Tag;

public record ArticleWriteCommand(
    Long memberId,
    Tag tag,
    String title,
    String content
) {

}
