package org.sopt.member.api.dto.request;

import static org.sopt.global.exception.ErrorCode.INVALID_DATE_FORMAT;
import static org.sopt.global.exception.ErrorCode.INVALID_EMAIL_FORMAT;
import static org.sopt.global.exception.ErrorCode.INVALID_MAPPING_PARAMETER;
import static org.sopt.global.exception.ErrorCode.INVALID_NULL_DATA;

import java.util.regex.Pattern;
import org.sopt.global.exception.BusinessException;

public record MemberCreateRequest(
    String name,
    String birthday,
    String email,
    String gender
) {

    private static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");

    public MemberCreateRequest {
        isNameNotNull(name);
        isValidBirthdayFormat(birthday);
        isValidEmailFormat(email);
        canConvertToGender(gender);
    }

    private void isNameNotNull(String name) {
        if (name == null || name.isBlank()) {
            throw new BusinessException(INVALID_NULL_DATA);
        }
    }

    private void isValidBirthdayFormat(String birthday) {
        if (birthday == null || !MemberCreateRequest.DATE_PATTERN.matcher(birthday).matches()) {
            throw new BusinessException(INVALID_DATE_FORMAT);
        }
    }

    private void isValidEmailFormat(String email) {
        if (email == null || !MemberCreateRequest.EMAIL_PATTERN.matcher(email).matches()) {
            throw new BusinessException(INVALID_EMAIL_FORMAT);
        }
    }

    private void canConvertToGender(String gender) {
        if (gender == null || (!gender.equals("MALE") && !gender.equals("FEMALE"))) {
            throw new BusinessException(INVALID_MAPPING_PARAMETER);
        }
    }
}
