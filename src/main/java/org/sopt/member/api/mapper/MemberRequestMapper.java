package org.sopt.member.api.mapper;

import java.time.LocalDate;
import org.sopt.member.api.dto.MemberCreateRequest;
import org.sopt.member.domain.model.Gender;
import org.sopt.member.application.dto.command.MemberJoinCommand;

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
