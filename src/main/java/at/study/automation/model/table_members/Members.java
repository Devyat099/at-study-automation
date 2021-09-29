package at.study.automation.model.table_members;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
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


    @Override
    public Members create(){
        throw new UnsupportedOperationException();
    }
}
