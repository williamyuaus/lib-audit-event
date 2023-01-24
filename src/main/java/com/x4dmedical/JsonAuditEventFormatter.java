package com.x4dmedical;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * It's a JSON implementation of {@link AuditEventFormatter}.
 *
 */
public class JsonAuditEventFormatter implements AuditEventFormatter {

    /**
     * Build a JSON representation of the audit event.
     *
     * @param event
     * @return
     */
    @Override
    public String formatEvent(AuditEvent event) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode JsonAuditEvent = mapper.createObjectNode();
            JsonAuditEvent.put("eventId", event.getEventId().toString());
            JsonAuditEvent.put("source", event.getSource());
            JsonAuditEvent.put("sourceAppName", event.getSourceAppName());
            JsonAuditEvent.put("targetAppName", event.getTargetAppName());
            JsonAuditEvent.put("target", event.getTarget());
            JsonAuditEvent.put("workflow", event.getWorkflow());
            JsonAuditEvent.put("traceId", event.getTraceId().toString());
            JsonAuditEvent.put("description", event.getDescription());
            JsonAuditEvent.put("createdTime", event.getCreatedTime().toString());

            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(JsonAuditEvent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
