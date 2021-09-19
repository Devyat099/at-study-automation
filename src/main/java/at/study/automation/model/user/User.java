package at.study.automation.model.user;

import at.study.automation.model.Creatable;
import at.study.automation.model.project.Progect;
import at.study.automation.model.role.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter

public class User extends CreatableEntity implements Creatable<User> {
    @NonNull
    private String login;
    @NonNull
    private String password = "qwerty12";
    private String salt;
    private String hashedPassword;
    private String firstName;
    private String lastName;
    private Boolean isAdmin;
    private Status status;
    private LocalDateTime lastLoginOn;
    private Language language;
    private String authSourceId;
    private String type;
    private String identityUrl;
    private MailNotification mailNotification;
    private Boolean mustChangePassword;
    private LocalDateTime passwordChangedOn;
    private List<Token> tokens;
    private List<Email> emails;

    @Override
    public User create() {
        throw new UnsupportedOperationException();
    }

    public void addProject(Progect progect, List<Role> roles) {
        // TODO реализовать с помощью sql запроса
    }
}
