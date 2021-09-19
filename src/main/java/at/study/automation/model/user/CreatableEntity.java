package at.study.automation.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Setter
@Getter

public abstract class CreatableEntity extends Entity {

    protected LocalDateTime createdOn;
    protected LocalDateTime updatedOn;

}
