package at.study.automation.model.roles;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TimeEntriesVisibility {
    ALL("all"),
    MY_TIME_ENTRIES("own");

    public final String timeEntriesVisibility;

}
