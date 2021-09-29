package at.study.automation.model.table_memberRoles;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
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



    @Override
    public MemberRoles create() {
        throw new UnsupportedOperationException();
    }
}
