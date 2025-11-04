package org.sopt.member.domain.model;

import static org.sopt.global.exception.ErrorCode.AGE_MUST_UPPER_THAN_20;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.sopt.article.domain.model.Article;
import org.sopt.member.domain.exception.MemberException;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthday;

    private String email;

    private Gender gender;

    @OneToMany
    private List<Article> articleList = new ArrayList<>();

    private Instant createdAt;

    private Instant updatedAt;

    public Member() {}

    private Member(
        Long id,
        String name,
        LocalDate birthday,
        String email,
        Gender gender,
        Instant createdAt,
        Instant updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Member of(
        String name,
        LocalDate birthday,
        String email,
        Gender gender
    ) {
        validateIsAdult(LocalDate.now(), birthday);
        return new Member(null, name, birthday, email, gender, null, null);
    }

    private static void validateIsAdult(LocalDate now, LocalDate birthday) {
        int age = now.getYear() - birthday.getYear() + 1;
        if (age < 20) {
            throw new MemberException(AGE_MUST_UPPER_THAN_20);
        }
    }
}
