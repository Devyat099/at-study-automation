package at.study.automation.model.table_memberRoles;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.model.table_members.Members;
import at.study.automation.model.table_roles.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberRoles extends CreatableEntity implements Creatable<MemberRoles> {


    // связано с таблицей members
    private Integer memberId;
    // связано с таблицей roles
    private Integer roleId;
    private Integer inheritedFrom;

    public MemberRoles(Members members, Role role) {
        this.memberId = members.getId();
        this.roleId = role.getId();
    }

    @Override
    public MemberRoles create() {
        throw new UnsupportedOperationException();
    }
}
