package at.study.automation.model.table_roles;

public enum TimeEntriesVisibility {
    ALL("all"),
    MY_TIME_ENTRIES("own");

    private final String TimeEntriesVisibility;

    TimeEntriesVisibility(String timeEntriesVisibility) {
        this.TimeEntriesVisibility = timeEntriesVisibility;
    }
}
