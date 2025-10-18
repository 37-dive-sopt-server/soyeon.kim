package org.sopt.member.application.port.in;

import org.sopt.member.application.dto.command.MemberJoinCommand;
import org.sopt.member.application.dto.result.MemberJoinResult;

public interface MemberJoinUseCase {

    MemberJoinResult join(MemberJoinCommand memberJoinCommand);
}
