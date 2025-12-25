package org.sopt.comment.api.dto.response;

import java.util.List;

public record GetCommentListResponse(
    List<GetCommentContentResponse> comments
){

}
