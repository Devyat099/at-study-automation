package at.study.automation.model.table_roles;

public enum TimeEntriesVisibility {
    ALL("all"),
    MY_TIME_ENTRIES("own");

    public final String timeEntriesVisibility;

    TimeEntriesVisibility(String timeEntriesVisibility) {
        this.timeEntriesVisibility = timeEntriesVisibility;
    }
}
