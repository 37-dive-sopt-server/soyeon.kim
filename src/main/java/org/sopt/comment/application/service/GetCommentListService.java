package org.sopt.comment.application.service;

import static org.sopt.article.domain.exception.ArticleErrorCode.ARTICLE_NOT_FOUND;

import lombok.RequiredArgsConstructor;
import org.sopt.article.domain.exception.ArticleException;
import org.sopt.article.domain.model.Article;
import org.sopt.article.domain.port.out.ArticleRepository;
import org.sopt.comment.application.dto.result.GetCommentListResult;
import org.sopt.comment.application.port.in.GetCommentListUsecase;
import org.sopt.comment.domain.model.Comment;
import org.sopt.comment.domain.port.out.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GetCommentListService implements GetCommentListUsecase {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Override
    public GetCommentListResult findByArticleId(Long articleId, int page, int size) {
        Article article = getExistingArticle(articleId);
        Pageable pageable = PageRequest.of(page, size);
        Page<Comment> commentPage = commentRepository.findByArticle(article, pageable);

        return GetCommentListResult.create(commentPage);
    }

    private Article getExistingArticle(Long articleId) {
        return articleRepository.findById(articleId)
            .orElseThrow(() -> new ArticleException(ARTICLE_NOT_FOUND));
    }

}
