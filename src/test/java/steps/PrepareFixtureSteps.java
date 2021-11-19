package steps;

import at.study.automation.context.Context;
import at.study.automation.model.users.User;
import cucumber.api.java.ru.Дано;

public class PrepareFixtureSteps {

    @Дано("В системе есть пользователь \"(.+)\" с правами администратора")
    public void createAdminUser(String userStashId) {
            User user = new User() {{
                setIsAdmin(true);
            }}.create();

        Context.getStash().put(userStashId, user);
    }
}
