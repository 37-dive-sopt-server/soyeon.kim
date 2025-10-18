package org.sopt.member.api.dto.response;

public record MemberInfoResponse (
    Long id,
    String name,
    String birthday,
    String email,
    String gender
){

}
