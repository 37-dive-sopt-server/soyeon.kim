package org.sopt.member.application.port.in;

import org.sopt.member.application.dto.result.MemberFindOneResult;

public interface MemberFindOneUsecase {

    MemberFindOneResult findOne(Long id);
}
