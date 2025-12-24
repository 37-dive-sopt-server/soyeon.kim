package org.sopt.comment.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record CommentUpdateRequest(
    @NotBlank
    @Max(300)
    String content
) {

}
