package at.study.automation.model.users;


import at.study.automation.db.request.TokenRequests;
import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Token extends CreatableEntity implements Creatable<Token> {

    private Integer userId;
    private TokenType action = TokenType.API;
    private String value = StringUtils.randomHexString(40);

    public enum TokenType {
        SESSION,
        API,
        FEEDS
    }

    public Token(User user) {
        this.userId = user.getId();
        user.getTokens().add(this);
    }


    @Override
    public Token create() {
        new TokenRequests().create(this);
        return this;
    }
}
