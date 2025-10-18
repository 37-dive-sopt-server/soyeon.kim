package org.sopt.cli;

import org.sopt.global.exception.GlobalExceptionHandler;
import org.sopt.global.response.ApiResponse;
import org.sopt.global.trace.TraceIdManager;
import org.sopt.member.api.MemberController;
import org.sopt.member.api.dto.request.MemberCreateRequest;

public class ConsoleApplication {

    private final MemberController memberController;
    private final ConsoleView consoleView;

    public ConsoleApplication(MemberController memberController, ConsoleView consoleView) {
        this.memberController = memberController;
        this.consoleView = consoleView;
    }

    public void run() {
        while (true) {
            TraceIdManager.createTraceId();
            consoleView.displayMenu();
            String choice = consoleView.readString("메뉴를 선택하세요: ");

            switch (choice) {
                case "1" -> createMember();
                case "2" -> findMemberById();
                case "3" -> findAllMembers();
                case "4" -> deleteMemberById();
                case "5" -> {
                    consoleView.displayExitMessage();
                    TraceIdManager.clear();
                    return;
                }
                default -> consoleView.displayInvalidMenu();
            }
        }
    }

    private void createMember() {
        try {
            String name = consoleView.readString("등록할 회원 이름을 입력하세요: ");
            if (name.trim().isEmpty()) {
                System.out.println("⚠️ 이름을 입력해주세요.");
                return;
            }

            String birthday = consoleView.readString("등록할 회원 생일을 입력하세요(2000-00-00): ");
            if (birthday.trim().isEmpty()) {
                System.out.println("⚠️ 생일을 입력해주세요.");
                return;
            }

            String email = consoleView.readString("등록할 회원 이메일을 입력하세요: ");
            if (email.trim().isEmpty()) {
                System.out.println("⚠️ 이메일을 입력해주세요.");
                return;
            }

            String gender = consoleView.readString("등록할 회원 성별을 입력하세요(MALE, FEMALE): ");
            if (gender.trim().isEmpty()) {
                System.out.println("⚠️ 성별을 입력해주세요.");
                return;
            }

            MemberCreateRequest request = new MemberCreateRequest(name, birthday, email, gender);
            ApiResponse<?, ?> response = memberController.createMember(request);
            consoleView.displaySuccess(response);
        } catch (Exception e) {
            consoleView.displayError(GlobalExceptionHandler.handle(e));
        }
    }

    private void findMemberById() {
        try {
            long id = consoleView.readLong("조회할 회원 ID를 입력하세요: ");
            ApiResponse<?, ?> response = memberController.findMemberById(id);
            consoleView.displaySuccess(response);
        } catch (Exception e) {
            consoleView.displayError(GlobalExceptionHandler.handle(e));
        }
    }

    private void findAllMembers() {
        try {
            var response = memberController.findAllMembers();
            consoleView.displayMembers(response);
        } catch (Exception e) {
            consoleView.displayError(GlobalExceptionHandler.handle(e));
        }
    }

    private void deleteMemberById() {
        try {
            long id = consoleView.readLong("삭제할 회원 ID를 입력하세요: ");
            ApiResponse<?, ?> response = memberController.deleteById(id);
            consoleView.displaySuccess(response);
        } catch (Exception e) {
            consoleView.displayError(GlobalExceptionHandler.handle(e));
        }
    }
}
