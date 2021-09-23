package at.study.automation.model.project;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter

public class Project extends CreatableEntity implements Creatable<Project> {

    private String name = "Devyat " + StringUtils.randomEnglishString(5);
    private String description;

    // Стартовая страница
    private String homepage;

    // Общедоступность проекта
    private Boolean isPublic = true;

    // parent id
    private Integer parentId = null;

    // Уникальный индетификатор. задается 1 раз
    private final String identifier;

    // Статус
    private Status status = Status.ACTIVE;

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

    public Project(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public Project create() {
        return null;
    }
}
