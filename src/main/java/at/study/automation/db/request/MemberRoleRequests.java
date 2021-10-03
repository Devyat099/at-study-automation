package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.memberRoles.MemberRoles;

public class MemberRoleRequests implements Create<MemberRoles> {


    @Override
    public void create(MemberRoles memberRoles) {

        String query = "INSERT INTO public.member_roles\n" +
                "(id, member_id, role_id, inherited_from)\n" +
                "VALUES(DEFAULT, ?, ?, ?) RETURNING id;\n";
        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                memberRoles.getMemberId(),
                memberRoles.getRoleId(),
                memberRoles.getInheritedFrom()).get(0).get("id");
        memberRoles.setId(id);
    }
}
