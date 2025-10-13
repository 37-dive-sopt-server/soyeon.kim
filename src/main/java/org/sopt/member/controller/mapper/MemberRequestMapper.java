package org.sopt.member.controller.mapper;

import java.time.LocalDate;
import org.sopt.member.controller.dto.MemberCreateRequest;
import org.sopt.member.domain.Gender;
import org.sopt.member.service.dto.MemberJoinCommand;

public class MemberRequestMapper {

    public static MemberJoinCommand toJoinCommand(MemberCreateRequest memberCreateRequest) {
        return new MemberJoinCommand(
            memberCreateRequest.name(),
            LocalDate.parse(memberCreateRequest.birthday()),
            memberCreateRequest.email(),
            Gender.from(memberCreateRequest.gender())
        );
    }
}
