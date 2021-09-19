package at.study.automation.model.user;


import at.study.automation.model.Creatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Email extends CreatableEntity implements Creatable<Email> {

    private Integer userId;
    private String address;
    private Boolean isDefault;
    private Boolean notify;

    @Override
    public Email create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }
}
