package at.study.automation.model.projects;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Project extends CreatableEntity implements Creatable<Project> {

    private String name = "111Devyat " + StringUtils.randomEnglishString(5);
    private String description = "description";
    private String homepage = "HomePage";
    private Boolean isPublic = true;
    private Integer parentId = null;
    private final String identifier = StringUtils.randomEnglishString(10);
    private Status status = Status.ACTIVE;
    private Integer ift = 1;
    private Integer rgt = 1;
    private Boolean inheritMembers = true;
    private Integer defaultVersionId = null;
    private Integer defaultAssignedToId = null;


    @Override
    public Project create() {
        return null;
    }
}
