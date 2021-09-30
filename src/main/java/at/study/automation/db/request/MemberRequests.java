package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.table_members.Members;

public class MemberRequests implements Create<Members> {

    @Override
    public void create(Members member) {
        String query = "INSERT INTO public.members\n" +
                "(id, user_id, project_id, created_on, mail_notification)\n" +
                "VALUES(DEFAULT, ?, ?, ?, ?) RETURNING id;\n";
        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                member.getUserId(),
                member.getProjectId(),
                member.getCreatedOn(),
                member.getMailNotification()).get(0).get("id");
        member.setId(id);
    }
}
