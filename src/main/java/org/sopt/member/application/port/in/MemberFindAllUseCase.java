package org.sopt.member.application.port.in;

import org.sopt.member.application.dto.result.MemberListResult;

public interface MemberFindAllUseCase {

    MemberListResult findAllMembers();
}
