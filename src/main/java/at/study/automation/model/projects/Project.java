package at.study.automation.model.projects;

import at.study.automation.db.request.ProjectRequests;
import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.utils.StringUtils;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Project extends CreatableEntity implements Creatable<Project> {

    private String name = "9299Devyat " + StringUtils.randomEnglishString(5);
    private String description = StringUtils.randomEnglishString(5);
    private String homepage = "HomePage";
    private Boolean isPublic = false;
    private Integer parentId = null;
    private String identifier = StringUtils.randomEnglishString(4);
    private Status status = Status.ACTIVE;
    private Integer ift = 1;
    private Integer rgt = 1;
    private Boolean inheritMembers = true;
    private Integer defaultVersionId = null;
    private Integer defaultAssignedToId = null;


    @Override
    @Step("Создан новый проект")
    public Project create() {
        new ProjectRequests().create(this);

        return this;
    }
}
