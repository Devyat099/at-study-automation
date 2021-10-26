package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.roles.Role;
import at.study.automation.model.users.User;

public class MemberRoleRequest {

    static public void create(Role role, User user) {
        String query = "INSERT INTO public.member_roles\n" +
                "(id, member_id, role_id, inherited_from)\n" +
                "VALUES(Default, ?, ?, ?) RETURNING id;\n";


        PostgresConnection.INSTANCE.executeQuery(
                query,
                user.getId(),
                role.getId(),
                null
        );
    }}