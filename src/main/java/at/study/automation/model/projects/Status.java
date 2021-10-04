package at.study.automation.model.projects;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum Status {
    ACTIVE(1),
    CLOSED(5),
    ARCHIVE(9);

    public final int statusCode;

}
