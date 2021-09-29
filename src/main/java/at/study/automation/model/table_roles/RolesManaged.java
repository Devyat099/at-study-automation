package at.study.automation.model.table_roles;

public enum RolesManaged {

    ALL_MANAGED(true),
    SOME_MANAGED(false);

    public final Boolean managed;

    RolesManaged(Boolean managed) {
        this.managed = managed;
    }
}
