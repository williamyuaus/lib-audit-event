package com.x4dmedical;

/**
 * This class represents the JSON based implementation of {@link Auditor}.
 *
 */
public class JsonAuditor implements Auditor {
    private final AuditEventFormatter formatter;

    public JsonAuditor() {
        this.formatter = new JsonAuditEventFormatter();
    }

    public JsonAuditor(AuditEventFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String audit(AuditEvent event) {
        return formatter.formatEvent(event);
    }
}
