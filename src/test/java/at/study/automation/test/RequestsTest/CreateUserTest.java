package at.study.automation.test.RequestsTest;

import at.study.automation.db.request.*;
import at.study.automation.model.table_emailAdresses.Email;
import at.study.automation.model.table_memberRoles.MemberRoles;
import at.study.automation.model.table_members.Members;
import at.study.automation.model.table_projects.Project;
import at.study.automation.model.table_roles.Role;
import at.study.automation.model.table_tokens.Token;
import at.study.automation.model.table_users.User;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void userCreateTest() {
        // Создание юзера в бд
        User userOne = new User();
        new UserRequests().create(userOne);
        Integer userOneId = userOne.getId();
        System.out.println(userOneId);

        // Создание проекта в бд
        Project projectOne = new Project();
        new ProjectRequests().create(projectOne);
        System.out.println(projectOne.getId() + " F"); //;project.getId();

        // Создание роли в бд
        Role role = new Role();
        new RolesRequests().create(role);

        // Создание токена в связке с юзером
        Token tokenOne = new Token(userOne);
        new TokenRequests().create(tokenOne);
        Integer tokenId = tokenOne.getUserId();
        System.out.println(tokenId);

        // Создание емейла в связке с юзером
        Email emailOne = new Email(userOne);
        new EmailRequests().create(emailOne);
        Integer emailId = emailOne.getUserId();
        System.out.println(emailId);

        // Создание members в связке с юзер + проект
        Members members = new Members(userOne,projectOne);
        new MemberRequests().create(members);
        Integer id = members.getId();
        System.out.println(id);

        // Создание memberRols в связке member+role
        MemberRoles memberRole = new MemberRoles(members, role);
        new MemberRoleRequests().create(memberRole);
    }
}
