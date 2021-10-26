package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.projects.Project;
import at.study.automation.model.users.User;

import java.time.LocalDateTime;

public class MemberRequest {

    public static void create(Project project, User user) {
        String query = "INSERT INTO public.members\n" +
                "(id, user_id, project_id, created_on, mail_notification)\n" +
                "VALUES(DEFAULT, ?, ?, ?, ?) RETURNING id;\n";
        Integer memberId = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                user.getId(),
                project.getId(),
                LocalDateTime.now(),
                !user.getEmails().isEmpty()
        ).get(0).get("id");

    }
}