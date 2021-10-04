package at.study.automation.model.roles;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum IssuesVisibility {

    ALL_TASK_VISIBILITY("all"),
    OWN_TASK_VISIBILITY("own"),
    DEFAULT_TASK_VISIBILITY("default");

    public final String taskVisibility;
}

