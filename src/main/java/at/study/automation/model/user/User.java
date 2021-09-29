package at.study.automation.model.user;

import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.model.project.Project;
import at.study.automation.model.role.Role;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.codec.digest.DigestUtils.sha1Hex;

@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class User extends CreatableEntity implements Creatable<User> {

    private String login = "Devyat" + StringUtils.randomEnglishString(10);
    private String password = "qwerty12";
    private String salt = StringUtils.randomHexString(32);
    private String hashedPassword = createHashedPassword();
    private String firstName = "Devyat" + StringUtils.randomEnglishString(10);
    private String lastName = "Devyat" + StringUtils.randomEnglishString(10);
    private Boolean isAdmin = false;
    private Status status = Status.ACTIVE;
    private LocalDateTime lastLoginOn;
    private Language language = Language.RUSSIAN;
    private String authSourceId;
    private String type = "User";
    private String identityUrl;
    private MailNotification mailNotification = MailNotification.NONE;
    private Boolean mustChangePassword = false;
    private LocalDateTime passwordChangedOn;
    private List<Token> tokens = new ArrayList<>();
    private List<Email> emails= new ArrayList<>();


    public void setPassword(String password) {
        this.password = password;
        this.hashedPassword = createHashedPassword();
    }

    public String createHashedPassword() {
        return sha1Hex(salt+ sha1Hex(password));
    }

    @Override
    public User create() {
        tokens.forEach(Token::create);
        emails.forEach(Email::create);
        throw new UnsupportedOperationException();
    }

    public void addProject(Project project, List<Role> roles) {
        // TODO реализовать с помощью sql запроса
    }
}
