package org.sopt.member.service.dto;

import java.time.LocalDate;
import org.sopt.member.domain.Gender;

public record MemberJoinCommand(
    String name,
    LocalDate birthday,
    String email,
    Gender gender
) {

}
