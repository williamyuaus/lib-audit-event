package com.x4dmedical;

/**
 * Represents the formatter interface for audit event.
 *
 */
public interface AuditEventFormatter {
    /**
     * Convert an audit event in a {@link String} representation.
     *
     * @param event
     * @return
     */
    String formatEvent(AuditEvent event);
}
