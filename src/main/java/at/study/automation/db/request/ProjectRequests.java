package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.table_projects.Project;

public class ProjectRequests implements Create<Project> {


    @Override
    public void create(Project project){
        String query = "INSERT INTO public.projects\n" +
                "(id, \"name\", description, homepage, is_public, parent_id, " +
                "created_on, updated_on, identifier, status, lft, rgt, inherit_members, " +
                "default_version_id, default_assigned_to_id)\n" +
                "VALUES(DEFAULT, ?, ?, " +
                "?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?) RETURNING id;\n";

        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                project.getName(),
                project.getDescription(),
                project.getHomepage(),
                project.getIsPublic(),
                project.getParentId(),
                project.getCreatedOn(),
                project.getUpdatedOn(),
                project.getIdentifier(),
                project.getStatus().statusCode,
                project.getIft(),
                project.getRgt(),
                project.getInheritMembers(),
                project.getDefaultVersionId(),
                project.getDefaultAssignedToId()).get(0).get("id");
        project.setId(id);
    }

}
