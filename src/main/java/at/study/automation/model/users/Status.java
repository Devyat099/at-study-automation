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

    public static Status of(int st) {
        return Stream.of(values())
                .filter(status -> status.statusCode == st)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не найден объект enum Status"));
    }
}
