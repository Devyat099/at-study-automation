package at.study.automation.model.user;


import at.study.automation.model.Creatable;
import at.study.automation.utils.StringUtils;
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
    private TokenType tokenType = TokenType.API;
    private String value = StringUtils.randomHexString(40);


    public enum TokenType {
        SESSION,
        API,
        FEEDS
    }

    @Override
    public Token create() {
        throw new UnsupportedOperationException();
    }
}
