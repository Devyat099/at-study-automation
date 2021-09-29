package at.study.automation.model.table_roles;

public enum UserVisibility {

    MEMBERS_OF_VISIBLE_PROJECTS("members_of_visible_projects"),
    ALL("all");

public final String userVisibility;

    UserVisibility(String userVisibility) {
        this.userVisibility = userVisibility;
    }
}
