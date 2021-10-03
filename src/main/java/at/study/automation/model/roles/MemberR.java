package at.study.automation.model.roles;

import at.study.automation.model.Creatable;
import at.study.automation.model.Entity;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor
@Setter
@Getter

public class MemberR extends Entity implements Creatable<MemberR> {

    private Integer memberId;
    private Integer roleId;
    private Integer inheritedForm;

    @Override
    public MemberR create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }
}
