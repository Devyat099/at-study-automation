package at.study.automation.test.RequestsTest;

import at.study.automation.db.request.*;
import at.study.automation.model.projects.Project;
import at.study.automation.model.roles.Role;
import at.study.automation.model.users.Email;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void userCreateTest() {
        // Создание пользователя
        User userOne = new User();
        new UserRequests().create(userOne);
        Integer userOneId = userOne.getId();
        System.out.println("Таблица users. id = " + userOneId);

        // Создание проекта
        Project projectOne = new Project();
        new ProjectRequests().create(projectOne);
        System.out.println("Таблица projects. id = " + projectOne.getId());

        // Создание роли
        Role role = new Role();
        new RolesRequests().create(role);
        System.out.println("Таблица roles. id = " + role.getId());

        // Создание tokens
        Token tokenOne = new Token(userOne);
        new TokenRequests().create(tokenOne);
        Integer tokenOneUserId = tokenOne.getUserId();
        System.out.printf("Таблица tokens. Поле user_id = %d; связан с полем user.id = %d\n", tokenOneUserId, userOneId);

        // Создание email
        Email emailOne = new Email(userOne);
        new EmailRequests().create(emailOne);
        Integer emailUserId = emailOne.getUserId();
        System.out.printf("Таблица email_addresses. Поле user_id = %d; связан с полем user.id = %d\n", emailUserId, userOneId);

    }
}
