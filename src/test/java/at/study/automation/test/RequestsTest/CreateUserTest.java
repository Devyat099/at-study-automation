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

        // Создание members
        Members members = new Members(userOne, projectOne);
        new MemberRequests().create(members);
        Integer membersUserId = members.getUserId();
        Integer membersProjectId = members.getProjectId();

        System.out.printf("Таблица members. user_id = %d, project_id = %d. Связаны с полями user.id = %d и projects.id = %d\n", membersUserId, membersProjectId, userOneId, projectOne.getId());


        // Создание memberRole
        MemberRoles memberRole = new MemberRoles(members, role);
        new MemberRoleRequests().create(memberRole);
        Integer memberId = memberRole.getMemberId();
        Integer roleMember = memberRole.getRoleId();
        System.out.printf("Таблица member_roles, member_id = %d, role_id = %d. Связаны с полями members.id = %d и role.id = %d\n", memberId, roleMember, members.getId(), role.getId());
    }
}
