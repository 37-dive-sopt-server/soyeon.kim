package org.sopt.member.api;

import org.sopt.member.api.dto.request.MemberCreateRequest;
import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.api.dto.response.MemberFindOneResponse;
import org.sopt.member.api.dto.response.MemberListResponse;
import org.sopt.member.api.mapper.MemberRequestMapper;
import org.sopt.member.api.mapper.MemberResponseMapper;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.dto.result.MemberJoinResult;
import org.sopt.member.application.dto.result.MemberListResult;
import org.sopt.member.application.port.in.MemberDeleteUseCase;
import org.sopt.member.application.port.in.MemberFindAllUseCase;
import org.sopt.member.application.port.in.MemberFindOneUseCase;
import org.sopt.member.application.port.in.MemberJoinUseCase;
import org.sopt.member.application.dto.command.MemberJoinCommand;

public class MemberController {

    private final MemberJoinUseCase memberJoinUseCase;
    private final MemberFindOneUseCase memberFindOneUseCase;
    private final MemberFindAllUseCase memberFindAllUseCase;
    private final MemberDeleteUseCase memberDeleteUseCase;

    public MemberController(
        MemberJoinUseCase memberJoinUseCase,
        MemberFindOneUseCase memberFindOneUseCase,
        MemberFindAllUseCase memberFindAllUseCase,
        MemberDeleteUseCase memberDeleteUseCase
    ) {
        this.memberJoinUseCase = memberJoinUseCase;
        this.memberFindOneUseCase = memberFindOneUseCase;
        this.memberFindAllUseCase = memberFindAllUseCase;
        this.memberDeleteUseCase = memberDeleteUseCase;
    }

    public MemberCreateResponse createMember(MemberCreateRequest createRequest) {
        MemberJoinCommand memberJoinCommand = MemberRequestMapper.toJoinCommand(createRequest);
        MemberJoinResult memberJoinResult = memberJoinUseCase.join(memberJoinCommand);
        return MemberResponseMapper.toMemberCreateResponse(memberJoinResult);
    }

    public MemberFindOneResponse findMemberById(Long id) {
        MemberFindOneResult memberFindOneResult = memberFindOneUseCase.findOne(id);
        return MemberResponseMapper.toMemberFindOneResponse(memberFindOneResult);
    }

    public MemberListResponse findAllMembers() {
        MemberListResult memberListResult = memberFindAllUseCase.findAllMembers();
        return MemberResponseMapper.toMemberListResponse(memberListResult);
    }

    public void deleteById(Long id) {
        memberDeleteUseCase.deleteMember(id);
    }
}
