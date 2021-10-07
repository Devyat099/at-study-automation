package at.study.automation.db.request;

import java.sql.Timestamp;
import java.time.LocalDateTime;

abstract class BaseRequests {

    protected LocalDateTime toLocalDate(Object timestamp) {
        Timestamp ts = (Timestamp) timestamp;
        return ts.toLocalDateTime();
    }

}