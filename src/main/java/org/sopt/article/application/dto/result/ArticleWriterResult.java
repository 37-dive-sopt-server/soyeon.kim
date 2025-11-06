package org.sopt.article.application.dto.result;

import org.sopt.member.domain.model.Member;

public record ArticleWriterResult(
    Long id,
    String name
) {

    public static ArticleWriterResult from(Member member) {
        return new ArticleWriterResult(member.getId(), member.getName());
    }
}
