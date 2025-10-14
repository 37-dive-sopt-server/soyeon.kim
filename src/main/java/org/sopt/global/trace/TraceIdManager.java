package org.sopt.global.trace;

import java.util.UUID;

public class TraceIdManager {

    private static final ThreadLocal<String> TRACE_ID_HOLDER = new ThreadLocal<>();

    public static void createTraceId() {
        String traceId = UUID.randomUUID().toString().substring(0, 8);
        TRACE_ID_HOLDER.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_ID_HOLDER.get();
    }

    public static void clear() {
        TRACE_ID_HOLDER.remove();
    }
}
