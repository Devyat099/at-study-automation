package at.study.automation.model.table_users;

public enum MailNotification {
    ALL("О всех событиях во всех моих проектах"),
    ONLY_MY_EVENTS("Только для обьектов, которые я отслеживаю или в которых участвую"),
    ONLY_ASSIGNED("Только для обьектов, которые я отслеживаю, или которые мнен назначены"),
    ONLY_OWNER("Только для обьектов, которые я отслеживаю или для которых я владелец"),
    NONE("Нет событий");

        private final String description;

    MailNotification(String description) {
        this.description = description;
    }
}
