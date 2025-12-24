package org.sopt.comment.application.service;

import static org.sopt.article.domain.exception.ArticleErrorCode.ARTICLE_NOT_FOUND;
import static org.sopt.member.domain.exception.MemberErrorCode.MEMBER_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.article.domain.exception.ArticleException;
import org.sopt.article.domain.model.Article;
import org.sopt.article.domain.port.out.ArticleRepository;
import org.sopt.comment.application.dto.command.CommentCreateCommand;
import org.sopt.comment.application.dto.result.CommentCreateResult;
import org.sopt.comment.application.port.in.CommentCreateUsecase;
import org.sopt.comment.domain.model.Comment;
import org.sopt.comment.domain.port.out.CommentRepository;
import org.sopt.member.domain.exception.MemberException;
import org.sopt.member.domain.model.Member;
import org.sopt.member.domain.port.out.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentCreateService implements CommentCreateUsecase {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Override
    public CommentCreateResult writeComment(CommentCreateCommand commentCreateCommand) {
        Member member = memberRepository.findById(commentCreateCommand.userId())
            .orElseThrow(() -> new MemberException(MEMBER_NOT_FOUND));
        Article article = articleRepository.findById(commentCreateCommand.articleId())
            .orElseThrow(() -> new ArticleException(ARTICLE_NOT_FOUND));
        Comment comment = Comment.create(article, member, commentCreateCommand.content());
        commentRepository.save(comment);

        return CommentCreateResult.create(comment);
    }
}
