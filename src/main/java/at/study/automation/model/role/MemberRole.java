package at.study.automation.model.role;

import at.study.automation.model.Creatable;
import at.study.automation.model.user.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MemberRole extends Entity implements Creatable<MemberRole> {

    private Integer memberId;
    private Integer roleId;
    private Integer inheritedForm;

    @Override
    public MemberRole create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }
}
