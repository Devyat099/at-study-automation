package at.study.automation.model.table_emailAdresses;


import at.study.automation.model.Creatable;
import at.study.automation.model.CreatableEntity;
import at.study.automation.model.table_users.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static at.study.automation.utils.StringUtils.randomEmail;

@Setter
@Getter
@Accessors(chain = true)
public class Email extends CreatableEntity implements Creatable<Email> {

    private Integer userId;
    private String address = randomEmail();
    private Boolean isDefault = true;
    private Boolean notify = true;

    public Email(User user) {
        this.userId = user.getId();
        user.getEmails().add(this);
    }


    @Override
    public Email create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }
}
