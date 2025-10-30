package org.sopt.member.api;

import static org.sopt.global.response.SuccessCode.MEMBER_CREATED_SUCCESS;
import static org.sopt.global.response.SuccessCode.MEMBER_DELETED_SUCCESS;
import static org.sopt.global.response.SuccessCode.MEMBER_LIST_RETRIEVED_SUCCESS;
import static org.sopt.global.response.SuccessCode.MEMBER_RETRIEVED_SUCCESS;

import org.sopt.global.response.ApiResponseBody;
import org.sopt.member.api.dto.request.MemberCreateRequest;
import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.api.dto.response.MemberFindOneResponse;
import org.sopt.member.api.dto.response.MemberListResponse;
import org.sopt.member.api.mapper.MemberRequestMapper;
import org.sopt.member.api.mapper.MemberResponseMapper;
import org.sopt.member.application.dto.command.MemberJoinCommand;
import org.sopt.member.application.dto.result.MemberFindOneResult;
import org.sopt.member.application.dto.result.MemberJoinResult;
import org.sopt.member.application.dto.result.MemberListResult;
import org.sopt.member.application.port.in.MemberDeleteUseCase;
import org.sopt.member.application.port.in.MemberFindAllUseCase;
import org.sopt.member.application.port.in.MemberFindOneUseCase;
import org.sopt.member.application.port.in.MemberJoinUseCase;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponseBody<MemberCreateResponse, Void>>createMember(
        @RequestBody MemberCreateRequest createRequest
    ) {
        MemberJoinCommand memberJoinCommand = MemberRequestMapper.toJoinCommand(createRequest);
        MemberJoinResult memberJoinResult = memberJoinUseCase.join(memberJoinCommand);
        MemberCreateResponse responseData = MemberResponseMapper.toMemberCreateResponse(memberJoinResult);

        return ResponseEntity.status(201)
            .body(ApiResponseBody.created(MEMBER_CREATED_SUCCESS, responseData));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseBody<MemberFindOneResponse, Void>> findMemberById(
        @PathVariable Long id
    ) {
        MemberFindOneResult memberFindOneResult = memberFindOneUseCase.findOne(id);
        MemberFindOneResponse responseData = MemberResponseMapper.toMemberFindOneResponse(memberFindOneResult);
        return ResponseEntity.status(200)
            .body(ApiResponseBody.ok(MEMBER_RETRIEVED_SUCCESS, responseData));
    }

    @GetMapping
    public ResponseEntity<ApiResponseBody<MemberListResponse, Void>> findAllMembers() {
        MemberListResult memberListResult = memberFindAllUseCase.findAllMembers();
        MemberListResponse responseData = MemberResponseMapper.toMemberListResponse(memberListResult);
        return ResponseEntity.status(200)
            .body(ApiResponseBody.ok(MEMBER_LIST_RETRIEVED_SUCCESS, responseData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseBody<Void, Void>> deleteById(@PathVariable Long id) {
        memberDeleteUseCase.deleteMember(id);
        return ResponseEntity.status(200)
            .body(ApiResponseBody.ok(MEMBER_DELETED_SUCCESS));
    }
}
