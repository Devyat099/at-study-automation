package at.study.automation.model.user;


import at.study.automation.model.Creatable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Setter
@Getter
public class Token extends CreatableEntity implements Creatable<Token> {


    private Integer userId;
    private Action action;
    private String value;


    public enum Action {
        SESSION,
        API,
        FEEDS
    }

    @Override
    public Token create() {
        throw new UnsupportedOperationException();
    }
}
