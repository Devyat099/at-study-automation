package at.study.automation.model.roles;

public enum RolesManaged {

    ALL_MANAGED(true),
    SOME_MANAGED(false);

    public final Boolean managed;

    RolesManaged(Boolean managed) {
        this.managed = managed;
    }
}
