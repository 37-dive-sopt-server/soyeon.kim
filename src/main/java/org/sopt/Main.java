package org.sopt;

import java.util.Scanner;
import org.sopt.global.exception.GlobalExceptionHandler;
import org.sopt.global.trace.TraceIdManager;
import org.sopt.member.api.MemberController;
import org.sopt.member.api.dto.request.MemberCreateRequest;
import org.sopt.member.api.dto.response.MemberCreateResponse;
import org.sopt.member.api.dto.response.MemberFindOneResponse;
import org.sopt.member.api.dto.response.MemberInfoResponse;
import org.sopt.member.api.dto.response.MemberListResponse;
import org.sopt.member.application.port.in.MemberDeleteUsecase;
import org.sopt.member.application.port.in.MemberFindAllUsecase;
import org.sopt.member.application.port.in.MemberFindOneUsecase;
import org.sopt.member.application.port.in.MemberJoinUsecase;
import org.sopt.member.application.service.MemberDeleteService;
import org.sopt.member.application.service.MemberFindAllService;
import org.sopt.member.application.service.MemberFindOneService;
import org.sopt.member.application.service.MemberJoinService;
import org.sopt.member.domain.port.out.MemberRepositoryPort;
import org.sopt.member.infrastructure.MemoryMemberRepository;

public class Main {

    public static void main(String[] args) {

        // TODO AppConfig 로 빼기
        MemberController memberController = getMemberController();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            TraceIdManager.createTraceId();

            System.out.println("\n✨ --- DIVE SOPT 회원 관리 서비스 --- ✨");
            System.out.println("---------------------------------");
            System.out.println("1️⃣. 회원 등록 ➕");
            System.out.println("2️⃣. ID로 회원 조회 🔍");
            System.out.println("3️⃣. 전체 회원 조회 📋");
            System.out.println("4️⃣. ID로 회원 삭제 ❌");
            System.out.println("5️⃣. 종료 🚪");
            System.out.println("---------------------------------");
            System.out.print("메뉴를 선택하세요: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("등록할 회원 이름을 입력하세요: ");
                        String name = scanner.nextLine();
                        if (name.trim().isEmpty()) {
                            System.out.println("⚠️ 이름을 입력해주세요.");
                            continue;
                        }

                        System.out.print("등록할 회원 생일을 입력하세요(2000-00-00): ");
                        String birthday = scanner.nextLine();
                        if (birthday.trim().isEmpty()) {
                            System.out.println("⚠️ 생일을 입력해주세요.");
                            continue;
                        }

                        System.out.print("등록할 회원 이메일을 입력하세요: ");
                        String email = scanner.nextLine();
                        if (email.trim().isEmpty()) {
                            System.out.println("⚠️ 이메일을 입력해주세요.");
                            continue;
                        }

                        System.out.print("등록할 회원 성별을 입력하세요(MALE, FEMALE): ");
                        String gender = scanner.nextLine();
                        if (gender.trim().isEmpty()) {
                            System.out.println("⚠️ 성별을 입력해주세요.");
                            continue;
                        }

                        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
                            name,
                            birthday,
                            email,
                            gender
                        );
                        MemberCreateResponse response = memberController
                            .createMember(memberCreateRequest);
                        Long createdId = response.id();

                        if (createdId != null) {
                            System.out.println("✅ 회원 등록 완료 (ID: " + createdId + ")");
                        } else {
                            System.out.println("❌ 회원 등록 실패");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ 회원 등록 실패");
                        GlobalExceptionHandler.handle(e);
                    }
                    break;
                case "2":
                    System.out.print("조회할 회원 ID를 입력하세요: ");
                    try {
                        Long id = Long.parseLong(scanner.nextLine());
                        MemberFindOneResponse foundMember = memberController.findMemberById(id);
                        System.out.println("✅ 조회된 회원: ID= " + foundMember.id()
                            + ", 이름= " + foundMember.name()
                            + ", 생년월일= " + foundMember.birthday()
                            + ", 이메일= " + foundMember.email()
                            + ", 성별= " + foundMember.gender());
                    } catch (NumberFormatException e) {
                        System.out.println("❌ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요.");
                        GlobalExceptionHandler.handle(e);
                    } catch (Exception e) {
                        System.out.println("❌ 회원 조회 실패");
                        GlobalExceptionHandler.handle(e);
                    }
                    break;
                case "3":
                    MemberListResponse allMembers = memberController.getAllMembers();
                    if (allMembers.members().isEmpty()) {
                        System.out.println("ℹ️ 등록된 회원이 없습니다.");
                    } else {
                        System.out.println("--- 📋 전체 회원 목록 📋 ---");
                        for (MemberInfoResponse member : allMembers.members()) {
                            System.out.println(
                                "👤 ID=" + member.id() + ", 이름=" + member.name()
                                    + ", 생년월일= " + member.birthday()
                                    + ", 이메일= " + member.email()
                                    + ", 성별= " + member.gender()
                            );
                        }
                        System.out.println("--------------------------");
                    }
                    break;
                case "4":
                    System.out.print("삭제할 회원 ID를 입력하세요: ");
                    try {
                        Long id = Long.parseLong(scanner.nextLine());
                        memberController.deleteById(id);
                        System.out.println("✅ 회원 삭제 완료 (ID: " + id + ")");
                    } catch (NumberFormatException e) {
                        System.out.println("❌ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요.");
                    } catch (Exception e) {
                        System.out.println("❌ 회원 삭제 실패");
                        GlobalExceptionHandler.handle(e);
                    }
                    break;
                case "5":
                    System.out.println("👋 서비스를 종료합니다. 안녕히 계세요!");
                    scanner.close();
                    TraceIdManager.clear();
                    return;
                default:
                    System.out.println("🚫 잘못된 메뉴 선택입니다. 다시 시도해주세요.");
            }
        }
    }

    private static MemberController getMemberController() {
        MemberRepositoryPort memberRepository = new MemoryMemberRepository();
        MemberJoinUsecase memberJoinUsecase = new MemberJoinService(memberRepository);
        MemberFindOneUsecase memberFindOneUsecase = new MemberFindOneService(memberRepository);
        MemberFindAllUsecase memberFindAllUsecase = new MemberFindAllService(memberRepository);
        MemberDeleteUsecase memberDeleteUsecase = new MemberDeleteService(memberRepository);
        return new MemberController(
            memberJoinUsecase,
            memberFindOneUsecase,
            memberFindAllUsecase,
            memberDeleteUsecase
        );
    }
}
