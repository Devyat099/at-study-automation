package at.study.automation.model.role;

public enum Settings {

    VIEW_TASK(true),
    ADD_TASK(true),
    EDITING_TASK(true),
    ADD_NOTES(true),
    DELETE_TASK(true);

    public final Boolean settings;

    Settings(Boolean settings) {
        this.settings = settings;
    }
}
