package at.study.automation.model.project;

import at.study.automation.model.Creatable;
import at.study.automation.model.Entity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter

public class Progect extends Entity implements Creatable<Progect> {

    // Наименование project
    private String name = "Devyat " + StringUtils.randomEnglishString(5);

    // описание проекта
    private String description;

    // Стартовая страница
    private String homepage;

    // Общедоступность проекта
    private Boolean isPublic = true;

    // parent id
    private Integer parentId = null;

    // Дата и время создания +3
    private LocalDateTime createdOn;

    // Время последнего обновления +3
    private LocalDateTime updateOn;

    // Уникальный индетификатор. задается 1 раз
    private final String identifier;

    // Статус
    private Integer status = 1;

    // ift
    private Integer ift = 1;

    // rgt
    private Integer rgt = 1;

    // наследование участников
    private Boolean inheritMembers = true;

    // default version id
    private Integer defaultVersionId = null;

    // default assigned to id
    private Integer defaultAssignedToId = null;

    public Progect(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public Progect create() {
        return null;
    }
}
