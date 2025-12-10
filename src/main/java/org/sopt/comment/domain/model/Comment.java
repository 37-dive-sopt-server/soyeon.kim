package org.sopt.comment.domain.model;

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
import lombok.RequiredArgsConstructor;
import org.sopt.article.domain.model.Article;
import org.sopt.global.model.BaseEntity;
import org.sopt.member.domain.model.Member;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    @Column(nullable = false, length = 300)
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

    private void validateComment(Article article, Member author, String content) {
        validateArticle(article);
        validateAuthor(author);
        validateContent(content);
    }

    private void validateArticle(Article article) {

    }

    private void validateAuthor(Member author) {

    }

    private void validateContent(String content) {

    }

}
