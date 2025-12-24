package org.sopt.comment.domain.model;

import static org.sopt.comment.domain.exception.CommentErrorCode.ARTICLE_REQUIRED;
import static org.sopt.comment.domain.exception.CommentErrorCode.COMMENT_EDIT_FORBIDDEN;
import static org.sopt.comment.domain.exception.CommentErrorCode.CONTENT_REQUIRED;
import static org.sopt.comment.domain.exception.CommentErrorCode.CONTENT_TOO_LONG;
import static org.sopt.comment.domain.exception.CommentErrorCode.MEMBER_REQUIRED;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.article.domain.model.Article;
import org.sopt.comment.domain.exception.CommentException;
import org.sopt.global.model.BaseEntity;
import org.sopt.member.domain.model.Member;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseEntity {

    private static final int MAX_CONTENT_LENGTH = 300;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    @Column(nullable = false, length = MAX_CONTENT_LENGTH)
    private String content;

    @Builder(access = AccessLevel.PRIVATE)
    private Comment(Article article, Member author, String content) {
        validateComment(article, author, content);
        this.article = article;
        this.author = author;
        this.content = content;
    }

    public static Comment create(Article article, Member author, String content) {
        return Comment.builder()
            .article(article)
            .author(author)
            .content(content)
            .build();
    }

    public void update(Long userId, String content) {
        validateCanEdit(userId);
        validateContent(content);
        this.content = content;
    }

    private void validateCanEdit(Long userId) {
        if(!this.author.getId().equals(userId)) {
            throw new CommentException(COMMENT_EDIT_FORBIDDEN);
        }
    }

    private void validateComment(Article article, Member author, String content) {
        validateArticle(article);
        validateAuthor(author);
        validateContent(content);
    }

    private void validateArticle(Article article) {
        if (article == null) {
            throw new CommentException(ARTICLE_REQUIRED);
        }
    }

    private void validateAuthor(Member author) {
        if (author == null) {
            throw new CommentException(MEMBER_REQUIRED);
        }
    }

    private void validateContent(String content) {
        validateContentNotEmpty(content);
        validateContentLength(content);
    }

    private void validateContentNotEmpty(String content) {
        if (content == null || content.isBlank()) {
            throw new CommentException(CONTENT_REQUIRED);
        }
    }

    private void validateContentLength(String content) {
        if (content.length() > MAX_CONTENT_LENGTH) {
            throw new CommentException(CONTENT_TOO_LONG);
        }
    }

}
