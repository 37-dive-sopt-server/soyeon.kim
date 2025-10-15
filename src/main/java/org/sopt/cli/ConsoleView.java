package org.sopt.cli;

import java.util.Scanner;
import org.sopt.global.response.ApiResponse;
import org.sopt.global.response.ErrorMeta;
import org.sopt.member.api.dto.response.MemberInfoResponse;
import org.sopt.member.api.dto.response.MemberListResponse;

public class ConsoleView {

    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n✨ --- DIVE SOPT 회원 관리 서비스 --- ✨");
        System.out.println("---------------------------------");
        System.out.println("1️⃣. 회원 등록 ➕");
        System.out.println("2️⃣. ID로 회원 조회 🔍");
        System.out.println("3️⃣. 전체 회원 조회 📋");
        System.out.println("4️⃣. ID로 회원 삭제 ❌");
        System.out.println("5️⃣. 종료 🚪");
        System.out.println("---------------------------------");
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public long readLong(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ 숫자만 입력해주세요.");
            }
        }
    }

    public void displaySuccess(ApiResponse<?, ?> response) {
        System.out.println("✅ " + response.message());
        if (response.data() != null) {
            System.out.println(response.data());
        }
    }

    public void displayError(ApiResponse<Void, ErrorMeta> errorResponse) {
        System.out.println("❌ 요청 처리 실패");
        System.out.printf("[Code: %s] %s%n", errorResponse.code(), errorResponse.message());
        if (errorResponse.meta() != null) {
            System.out.printf("[TraceId: %s]%n", errorResponse.meta().traceId());
        }
    }

    public void displayMembers(ApiResponse<MemberListResponse, Void> response) {
        if (response.data().members().isEmpty()) {
            System.out.println("ℹ️ 등록된 회원이 없습니다.");
            return;
        }
        System.out.println("--- 📋 전체 회원 목록 📋 ---");
        for (MemberInfoResponse member : response.data().members()) {
            System.out.println("👤 " + member.toString());
        }
        System.out.println("--------------------------");
    }

    public void displayExitMessage() {
        System.out.println("👋 서비스를 종료합니다. 안녕히 계세요!");
        scanner.close();
    }

    public void displayInvalidMenu() {
        System.out.println("🚫 잘못된 메뉴 선택입니다. 다시 시도해주세요.");
    }
}
