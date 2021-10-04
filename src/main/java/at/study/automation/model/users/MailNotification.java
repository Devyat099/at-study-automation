package at.study.automation.model.users;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MailNotification {
    ALL("О всех событиях во всех моих проектах"),
    ONLY_MY_EVENTS("Только для обьектов, которые я отслеживаю или в которых участвую"),
    ONLY_ASSIGNED("Только для обьектов, которые я отслеживаю, или которые мнен назначены"),
    ONLY_OWNER("Только для обьектов, которые я отслеживаю или для которых я владелец"),
    NONE("Нет событий");

    private final String description;

}
