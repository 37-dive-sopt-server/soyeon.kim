package org.sopt.member.api.dto.request;

public record MemberCreateRequest(
    String name,
    String birthday,
    String email,
    String gender
) {

}
