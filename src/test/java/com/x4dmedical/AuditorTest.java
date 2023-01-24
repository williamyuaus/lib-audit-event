package com.x4dmedical;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuditorTest {

    private Auditor auditor;

    @Test
    public void testAudit() throws ParseException {
        auditor = new JsonAuditor();
        String result = auditor.audit(AuditEvent.builder()
                .eventId(getMockUUID())
                .source("TEST1.2.3.4.5")
                .sourceAppName("BATCHAGENT")
                .targetAppName("DATASET-SVC")
                .target("1.2.3.4.5.6")
                .workflow("DOWNLOAD_DATASET")
                .traceId(getMockUUID())
                .description("description")
                .createdTime(getMockTimestamp())
                .build());
        assertEquals("{\r\n" +
            "  \"eventId\" : \"de78cbb6-9b69-4c7e-809c-4d07bd139aab\",\r\n" +
            "  \"source\" : \"TEST1.2.3.4.5\",\r\n" +
            "  \"sourceAppName\" : \"BATCHAGENT\",\r\n" +
            "  \"targetAppName\" : \"DATASET-SVC\",\r\n" +
            "  \"target\" : \"1.2.3.4.5.6\",\r\n" +
            "  \"workflow\" : \"DOWNLOAD_DATASET\",\r\n" +
            "  \"traceId\" : \"de78cbb6-9b69-4c7e-809c-4d07bd139aab\",\r\n" +
            "  \"description\" : \"description\",\r\n" +
            "  \"createdTime\" : \"2023-01-01 00:00:00.0\"\r\n" +
            "}", result);
    }


    private UUID getMockUUID() {
        return UUID.fromString("de78cbb6-9b69-4c7e-809c-4d07bd139aab");
    }

    private Timestamp getMockTimestamp() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("01/01/2023");
        long time = date.getTime();
        return new Timestamp(time);
    }

}
