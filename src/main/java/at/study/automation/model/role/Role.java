package at.study.automation.model.role;

import at.study.automation.model.Creatable;
import at.study.automation.model.user.Entity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;
@NoArgsConstructor
@Setter
@Getter
public class Role extends Entity implements Creatable<Role>  {

    private String name = "Coach" + StringUtils.randomEnglishString(5);
    private Integer position = (new Random()).nextInt(1999);
    private Boolean assignable = true;
    private final Integer builtin = 0;
    private final String permissions = "---";
    private String issuesVisibility = "default";
    private String userVisibility = "all";
    private String timeEntriesVisiblity = "all";
    private Boolean allRolesManaged = true;
    private String settings; // TODO

    @Override
    public Role create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }

    }

