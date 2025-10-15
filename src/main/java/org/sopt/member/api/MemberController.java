package org.sopt.member.api;

import java.util.List;
import org.sopt.member.api.dto.request.MemberCreateRequest;
import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.api.dto.response.MemberFindOneResponse;
import org.sopt.member.api.dto.response.MemberListResponse;
import org.sopt.member.api.mapper.MemberRequestMapper;
import org.sopt.member.api.mapper.MemberResponseMapper;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.dto.result.MemberJoinResult;
import org.sopt.member.application.dto.result.MemberListResult;
import org.sopt.member.application.port.in.MemberFindAllUsecase;
import org.sopt.member.application.port.in.MemberFindOneUsecase;
import org.sopt.member.application.port.in.MemberJoinUsecase;
import org.sopt.member.domain.model.Member;
import org.sopt.member.application.port.in.MemberUsecase;
import org.sopt.member.application.dto.command.MemberJoinCommand;

public class MemberController {

    // TODO 유스케이스 별로 서비스 분리
    // TODO port, adapter 분리
    private final MemberUsecase memberUsecase;
    private final MemberJoinUsecase memberJoinUsecase;
    private final MemberFindOneUsecase memberFindOneUsecase;
    private final MemberFindAllUsecase memberFindAllUsecase;

    public MemberController(
        MemberUsecase memberUsecase,
        MemberJoinUsecase memberJoinUsecase,
        MemberFindOneUsecase memberFindOneUsecase,
        MemberFindAllUsecase memberFindAllUsecase
    ) {
        this.memberUsecase = memberUsecase;
        this.memberJoinUsecase = memberJoinUsecase;
        this.memberFindOneUsecase = memberFindOneUsecase;
        this.memberFindAllUsecase = memberFindAllUsecase;
    }

    public MemberCreateResponse createMember(MemberCreateRequest createRequest) {
        MemberJoinCommand memberJoinCommand = MemberRequestMapper.toJoinCommand(createRequest);
        MemberJoinResult memberJoinResult = memberJoinUsecase.join(memberJoinCommand);
        return MemberResponseMapper.toMemberCreateResponse(memberJoinResult);
    }

    public MemberFindOneResponse findMemberById(Long id) {
        MemberFindOneResult memberFindOneResult = memberFindOneUsecase.findOne(id);
        return MemberResponseMapper.toMemberFindOneResponse(memberFindOneResult);
    }

    public MemberListResponse getAllMembers() {
        MemberListResult memberListResult = memberFindAllUsecase.findAllMembers();
        return MemberResponseMapper.toMemberListResponse(memberListResult);
    }

    public void deleteById(Long id) {
        memberUsecase.deleteMember(id);
    }
}
