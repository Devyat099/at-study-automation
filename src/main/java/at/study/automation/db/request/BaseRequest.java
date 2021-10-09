package at.study.automation.db.request;

import at.study.automation.model.users.Status;

import java.sql.Timestamp;
import java.time.LocalDateTime;

abstract class BaseRequests {

    protected LocalDateTime toLocalDate(Object timestamp) {
        Timestamp ts = (Timestamp) timestamp;
        return ts.toLocalDateTime();
    }

    protected Status toStatusCode(int status) {

        Status st = new Status(status);

        return null;

    }
}