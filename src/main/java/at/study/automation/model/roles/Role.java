package at.study.automation.model.roles;

import at.study.automation.db.request.RolesRequests;
import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
@Setter
@Getter
public class Role extends CreatableEntity implements Creatable<Role> {

    private String name = "Devyat " + StringUtils.randomEnglishString(5);
    private Integer position = new Random().nextInt(1999);
    private Boolean assignable = true;
    private final Integer builtin = 0;
    private List<Permissions> permissions = new ArrayList<>();
    private IssuesVisibility issuesVisibility = IssuesVisibility.ALL_TASK_VISIBILITY;
    private UserVisibility userVisibility = UserVisibility.ALL;
    private TimeEntriesVisibility timeEntriesVisibility = TimeEntriesVisibility.ALL;
    private Boolean allRolesManaged = true;
    private Integer settings = null;


    @Override
    public Role create() {
        new RolesRequests().create(this);
        return this;
    }

}

