package org.sopt.member.domain.model;

import static org.sopt.global.exception.ErrorCode.AGE_MUST_UPPER_THAN_20;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.article.domain.model.Article;
import org.sopt.member.domain.exception.MemberException;

@Getter
@Builder(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public static Member of(
        String name,
        LocalDate birthday,
        String email,
        Gender gender
    ) {
        validateIsAdult(LocalDate.now(), birthday);

        return Member.builder()
            .name(name)
            .birthday(birthday)
            .email(email)
            .gender(gender)
            .build();
    }

    private static void validateIsAdult(LocalDate now, LocalDate birthday) {
        int age = now.getYear() - birthday.getYear() + 1;
        if (age < 20) {
            throw new MemberException(AGE_MUST_UPPER_THAN_20);
        }
    }
}
