package com.x4dmedical;

/**
 * This interface represents the entry point.
 * The auditing implementation may use any appropriate medium and format to store audit events.
 *
 */
public interface Auditor {
    String audit(AuditEvent event);
}
