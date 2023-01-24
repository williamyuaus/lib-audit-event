# lib-common-audit-event

This library provides a simple way to audit events in your application. It's very simple to add Auditor in your application.

## Building lib-common-audit-event
lib-common-audit-event  can be built by executing following command from /path/to/svc-tests-poc

`./gradlew clean build`

## Using lib-common-audit-event
It's very simple to add Auditor in your application:

```java
import java.util.UUID;

public class MyBusinessClass {

    private Auditor auditor = new JsonAuditor(); // or inject

    public void bussinesMethod() {
        // business
        auditor.audit(AuditEvent.builder()
            .eventId(UUID.randomUUID())
            .source("TEST1.2.3.4.5")
            .sourceAppName("BATCHAGENT")
            .targetAppName("DATASET-SVC")
            .target("1.2.3.4.5.6")
            .workflow("DOWNLOAD_DATASET")
            .traceId("1234567890")
            .description("description")
            .createdTime(System.currentTimeMillis())
            .build());
    }
}
```