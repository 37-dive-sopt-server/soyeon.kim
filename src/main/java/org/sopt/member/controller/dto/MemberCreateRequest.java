package org.sopt.member.controller.dto;

public record MemberCreateRequest(
    String name,
    String birthday,
    String email,
    String gender
) {

    public static MemberCreateRequest of(
        String name,
        String birthday,
        String email,
        String gender
    ) {
        return new MemberCreateRequest(name, birthday, email, gender);
    }
}
