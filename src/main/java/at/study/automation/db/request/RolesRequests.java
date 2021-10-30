package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.roles.Permissions;
import at.study.automation.model.roles.Role;

import java.util.List;
import java.util.Locale;

public class RolesRequests implements Create<Role> {

    @Override
    public void create(Role role) {
        String query = "INSERT INTO public.roles\n" +
                "(id, name, \"position\", assignable, builtin, permissions, issues_visibility, users_visibility, time_entries_visibility, all_roles_managed, settings)\n" +
                "VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;\n";
        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                role.getName(),
                role.getPosition(),
                role.getAssignable(),
                role.getBuiltin(),
                addPermissionsToRole(role.getPermissions()),
                role.getIssuesVisibility().taskVisibility,
                role.getUserVisibility().toString().toLowerCase(Locale.ROOT),
                role.getTimeEntriesVisibility().timeEntriesVisibility,
                role.getAllRolesManaged(),
                role.getSettings()).get(0).get("id");
        role.setId(id);

    }

    /**
     * @return готовая строка для вставки в таблицу roles бд
     */

    private String addPermissionsToRole(List<Permissions> per) {
        StringBuilder sb = new StringBuilder();
        sb.append("---\n");
        for (Permissions permissions : per) {
            sb.append("- :").append(permissions.toString().toLowerCase()).append("\n");
        }
        return sb.toString();
    }


}
