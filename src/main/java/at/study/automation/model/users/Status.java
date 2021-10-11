package at.study.automation.model.users;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor

public enum Status {
    UNREGISTERED(0),
    ACTIVE(1),
    UNACCEPTED(2),
    LOCKED(3);

    public final int statusCode;

    public static Status of(int description) {
        return Stream.of(values())
                .filter(status -> status.equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не найден обьект enum Status"));
    }
}
