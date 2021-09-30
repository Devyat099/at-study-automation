package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.table_roles.Permissions;
import at.study.automation.model.table_roles.Role;

import java.util.List;
import java.util.Locale;

public class RolesRequests implements Create<Role>{


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
                listPermissions(role.getPermissions()),
                role.getIssuesVisibility().taskVisibility,
                role.getUserVisibility().userVisibility,
                role.getTimeEntriesVisibility().timeEntriesVisibility,
                role.getAllRolesManaged().managed,
                role.getSettings()).get(0).get("id");
        role.setId(id);

    }

    private static String listPermissions(List<Permissions> per) {
        StringBuilder sb = new StringBuilder();
        sb.append("---\n");
        sb.append("- :" + (Permissions.ADD_PROJECT.name()).toLowerCase(Locale.ROOT) + "\n");
        sb.append("- :" + (Permissions.EDIT_PROJECT.name()).toLowerCase(Locale.ROOT) + "\n");
        sb.append("- :" + (Permissions.EDIT_MESSAGES.name()).toLowerCase(Locale.ROOT) + "\n");
        sb.append("- :" + (Permissions.MANAGE_WIKI.name()).toLowerCase(Locale.ROOT) + "\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        Role role = new Role();
        String i = listPermissions(role.getPermissions());
        System.out.println(i);
    }
}
