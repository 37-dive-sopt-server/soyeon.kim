package org.sopt.cli;

import org.sopt.member.api.MemberController;
import org.sopt.member.application.port.in.*;
import org.sopt.member.application.service.*;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.sopt.member.infrastructure.MemoryMemberRepository;

public class AppConfig {

    private final MemberRepositoryPort memberRepository = new MemoryMemberRepository();

    public MemberController memberController() {
        return new MemberController(
            memberJoinUseCase(),
            memberFindOneUseCase(),
            memberFindAllUseCase(),
            memberDeleteUseCase()
        );
    }

    public ConsoleApplication consoleApplication() {
        return new ConsoleApplication(memberController(), consoleView());
    }

    public ConsoleView consoleView() {
        return new ConsoleView();
    }

    private MemberJoinUseCase memberJoinUseCase() {
        return new MemberJoinService(this.memberRepository);
    }

    private MemberFindOneUseCase memberFindOneUseCase() {
        return new MemberFindOneService(this.memberRepository);
    }

    private MemberFindAllUseCase memberFindAllUseCase() {
        return new MemberFindAllService(this.memberRepository);
    }

    private MemberDeleteUseCase memberDeleteUseCase() {
        return new MemberDeleteService(this.memberRepository);
    }
}