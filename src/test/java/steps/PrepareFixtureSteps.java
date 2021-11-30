package steps;

import at.study.automation.context.Context;
import at.study.automation.model.users.Email;
import at.study.automation.model.users.Status;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import cucumber.api.java.ru.Дано;

import java.util.Collections;
import java.util.Map;

public class PrepareFixtureSteps {

    @Дано("В системе есть пользователь \"(.+)\" с параметрами:")
    public void createAdminUser(String userStashId, Map<String, String> params) {
        User user = new User();
        if (params.containsKey("Администратор")) {
            Boolean isAdmin = Boolean.parseBoolean(params.get("Администратор"));
            user.setIsAdmin(isAdmin);
        }

        if (params.containsKey("API keys")) {
            user.setTokens(Collections.singletonList(new Token(user)));
        }

        if (params.containsKey("Status")) {
            //int statusCode =Integer.parseInt(params.get("Status"));
            user.setEmails(Collections.singletonList(new Email(user)));
            user.setStatus(Status.UNACCEPTED);
        }

        user.create();
        Context.getStash().put(userStashId, user);
    }

}

