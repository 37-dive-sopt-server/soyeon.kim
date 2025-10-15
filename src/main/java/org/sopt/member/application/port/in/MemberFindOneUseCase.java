package org.sopt.member.application.port.in;

import org.sopt.member.application.dto.result.MemberFindOneResult;

public interface MemberFindOneUseCase {

    MemberFindOneResult findOne(Long id);
}
