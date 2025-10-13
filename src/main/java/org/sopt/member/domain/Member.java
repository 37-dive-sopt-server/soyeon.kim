package org.sopt.member.domain;

import java.time.Instant;
import java.time.LocalDate;

public class Member {

    private Long id;
    private String name;
    private LocalDate birthday;
    private String email;
    private Gender gender;
    private Instant createdAt;
    private Instant updatedAt;

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
       return new Member(null, name, birthday, email, gender, null, null);
    }

    public void updateId(Long id) {
        this.id = id;
    }

    public void updateCreatedAt(Instant now) {
        this.createdAt = now;
    }

    public void updateUpdatedAt(Instant now) {
        this.updatedAt = now;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
