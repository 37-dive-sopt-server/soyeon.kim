package org.sopt.article.application.service;

import static org.sopt.global.exception.ErrorCode.MEMBER_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.article.application.dto.command.ArticleWriteCommand;
import org.sopt.article.application.dto.result.ArticleCreateResult;
import org.sopt.article.application.port.in.ArticleWriteUsecase;
import org.sopt.article.domain.model.Article;
import org.sopt.article.domain.port.out.ArticleRepository;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleWriteService implements ArticleWriteUsecase {

    private final MemberRepositoryPort memberRepositoryPort;
    private final ArticleRepository articleRepository;

    public ArticleCreateResult writeArticle(ArticleWriteCommand articleWriteCommand) {
        // TODO 게시글 제목 중복 검증

        Member member = memberRepositoryPort.findById(articleWriteCommand.memberId())
            .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
        Article article = Article.create(
            member,
            articleWriteCommand.tag(),
            articleWriteCommand.title(),
            articleWriteCommand.content()
        );
        articleRepository.save(article);

        return ArticleCreateResult.from(article);
    }
}
