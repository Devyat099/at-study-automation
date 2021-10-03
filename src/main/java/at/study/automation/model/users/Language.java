package at.study.automation.model.users;

public enum  Language {
    RUSSIAN("ru"),
    ENGLISH("en");

    public final String languageCode;

    Language(String languageCode) {
        this.languageCode = languageCode;
    }
}
