package org.sopt.member.api;

import org.sopt.global.response.ApiResponse;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/members")
@RestController
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

    @PostMapping
    public ApiResponse<MemberCreateResponse, Void> createMember(
        @RequestBody MemberCreateRequest createRequest
    ) {
        MemberJoinCommand memberJoinCommand = MemberRequestMapper.toJoinCommand(createRequest);
        MemberJoinResult memberJoinResult = memberJoinUseCase.join(memberJoinCommand);
        MemberCreateResponse responseData = MemberResponseMapper.toMemberCreateResponse(memberJoinResult);

        return ApiResponse.created(responseData, "회원가입이 성공적으로 완료되었습니다.");
    }

    @GetMapping("/{id}")
    public ApiResponse<MemberFindOneResponse, Void> findMemberById(@PathVariable Long id) {
        MemberFindOneResult memberFindOneResult = memberFindOneUseCase.findOne(id);
        MemberFindOneResponse responseData = MemberResponseMapper.toMemberFindOneResponse(memberFindOneResult);
        return ApiResponse.ok(responseData, "회원 조회가 성공적으로 완료되었습니다.");
    }

    @GetMapping
    public ApiResponse<MemberListResponse, Void> findAllMembers() {
        MemberListResult memberListResult = memberFindAllUseCase.findAllMembers();
        MemberListResponse responseData = MemberResponseMapper.toMemberListResponse(memberListResult);
        return ApiResponse.ok(responseData, "회원 전체 조회가 성공적으로 완료되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void, Void> deleteById(@PathVariable Long id) {
        memberDeleteUseCase.deleteMember(id);
        return ApiResponse.ok("회원 삭제가 성공적으로 완료되었습니다.");
    }
}
