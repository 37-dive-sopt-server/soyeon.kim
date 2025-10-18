package org.sopt.member.domain.model;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender from(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("성별은 필수 입력입니다.");
        }

        try {
            return Gender.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 성별 값입니다: " + value);
        }
    }
}
