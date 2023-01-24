package com.x4dmedical;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * Represents the audit event.
 *
 */
@Builder
@Getter
@ToString
public class AuditEvent {
    @Builder.Default
    private UUID eventId = UUID.randomUUID();
    @lombok.NonNull
    private String source;
    @lombok.NonNull
    private String sourceAppName;
    @lombok.NonNull
    private String targetAppName;
    @lombok.NonNull
    private String target;
    @lombok.NonNull
    private String workflow;
    @lombok.NonNull
    private UUID traceId;
    @lombok.NonNull
    private String description;
    @Builder.Default
    private Timestamp createdTime = new Timestamp(System.currentTimeMillis());

}
