package at.study.automation.model.users;

public enum Status {
    UNREGISTERED(0),
    ACTIVE(1),
    UNACCEPTED(2),
    LOCKED(3);

    public final int statusCode;

    Status(int statusCode) {
        this.statusCode = statusCode;
    }
}
