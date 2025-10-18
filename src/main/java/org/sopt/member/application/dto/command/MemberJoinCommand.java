package org.sopt.member.application.dto.command;

import java.time.LocalDate;
import org.sopt.member.domain.model.Gender;

public record MemberJoinCommand(
    String name,
    LocalDate birthday,
    String email,
    Gender gender
) {

}
