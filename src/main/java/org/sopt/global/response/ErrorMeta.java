package org.sopt.global.response;

public record ErrorMeta(
    String traceId,
    String path,
    long timestamp
) {

}
