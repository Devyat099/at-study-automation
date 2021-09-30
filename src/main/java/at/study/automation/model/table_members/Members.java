package at.study.automation.model.table_members;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.model.table_projects.Project;
import at.study.automation.model.table_users.User;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Members extends CreatableEntity implements Creatable<Members> {

    // связано с таблицей users
    private Integer userId;
    // связано с таблицей projects
    private Integer projectId;
    private Boolean mailNotification = true;

    public Members(User user, Project project) {
        this.userId = user.getId();
        this.projectId = project.getId();
    }
    @Override
    public Members create(){
        throw new UnsupportedOperationException();
    }
}
