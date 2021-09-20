package at.study.automation.model.role;

public enum IssuesVisibility {

    ALL_TASK_VISIBILITY("Все задачи"),
    OWN_TASK_VISIBILITY("Задачи созданные или назначенные пользователю"),
    DEFAULT_TASK_VISIBILITY("Только общие задачи");

    public final String taskVisibility;

    IssuesVisibility(String taskVisibility) {
        this.taskVisibility = taskVisibility;
    }
}

