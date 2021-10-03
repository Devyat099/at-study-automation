package at.study.automation.model.projects;

public enum Status {
    ACTIVE(1),
    CLOSED(5),
    ARCHIVE(9);

    public final int statusCode;

    Status(int statusCode) {
        this.statusCode = statusCode;
    }
}