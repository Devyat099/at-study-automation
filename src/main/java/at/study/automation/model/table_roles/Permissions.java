package at.study.automation.model.table_roles;

public enum Permissions {
    // Создание проекта
    ADD_PROJECT(true),

    // Редактирование проектов
    EDIT_PROJECT(true),

    // Закрывать / открывать проекты
    CLOSE_PROJECT(true),

    // Выбор модулей проекта
    SELECT_PROJECT_MODULES(true),

    // Управление участниками
    MANAGE_MEMBERS(true),

    // Управление версиями
    MANAGE_VERSIONS(true),

    // Создание подпроектов
    ADD_SUBPROJECTS(true),

    // Управление общими запросами
    MANAGE_PUBLIC_QUERIES(true),

    // Сохранение запросов
    SAVE_QUERIES(true),

    // Просмотр сообщений
    VIEW_MESSAGES(true),

    // Отправка сообщений
    ADD_MESSAGES(true),

    // Редактирование сообщений
    EDIT_MESSAGES(true),

    // Редактирование собственных сообщений
    EDIT_OWN_MESSAGES(true),

    // Удаление сообщений
    DELETE_MESSAGES(true),

    // Удаление собственных сообщений
    DELETE_OWN_MESSAGES(true),

    // Управление форумами
    MANAGE_BOARDS(true),

    // Просмотр календаря
    VIEW_CALENDAR(true),

    // Просмотр документов
    VIEW_DOCUMENTS(true),

    // Добавить документы
    ADD_DOCUMENTS(true),

    // Редактировать документы
    EDIT_DOCUMENTS(true),

    // Удалить документы
    DELETE_DOCUMENTS(true),

    // Просмотр файлов
    VIEW_FILES(true),

    // Управление файлами
    MANAGE_FILES(true),

    // Просмотр диаграммы Ганта
    VIEW_GANTT(true),

    // Просмотр задач
    VIEW_ISSUES(true),

    // Добавление задач
    ADD_ISSUES(true),

    // Редактирование задач
    EDIT_ISSUES(true),

    // Редактировать свои задачи
    EDIT_OWN_ISSUES(true),

    // Копирование задач
    COPY_ISSUES(true),

    // Управление связыванием задач
    MANAGE_ISSUE_RELATIONS(true),

    // Управление подзадачами
    MANAGE_SUBTASKS(true),

    //  Установление видимости (общая/частная) для задач
    SET_ISSUES_PRIVATE(true),

    // Установление видимости (общая/частная) для собственных задач
    SET_OWN_ISSUES_PRIVATE(true),

    // Добавление примечаний
    ADD_ISSUE_NOTES(true),

    // Редактирование примечаний
    EDIT_ISSUE_NOTES(true),

    // Редактирование собственных примечаний
    EDIT_OWN_ISSUE_NOTES(true),

    // Просмотр приватных комментариев
    VIEW_PRIVATE_NOTES(true),

    // Размещение приватных комментариев
    SET_NOTES_PRIVATE(true),

    // Удаление задач
    DELETE_ISSUES(true),

    // Просмотр списка наблюдателей
    VIEW_ISSUE_WATCHERS(true),

    // Добавление наблюдателей
    ADD_ISSUE_WATCHERS(true),

    // Удаление наблюдателей
    DELETE_ISSUE_WATCHERS(true),

    // Импорт задач
    IMPORT_ISSUES(true),

    // Управление категориями задач
    MANAGE_CATEGORIES(true),

    // Просмотр новостей
    VIEW_NEWS(true),

    // Управление новостями
    MANAGE_NEWS(true),

    // Комментирование новостей
    COMMENT_NEWS(true),

    // Просмотр изменений хранилища
    VIEW_CHANGESETS(true),

    // Просмотр хранилища
    BROWSE_REPOSITORY(true),

    // Изменение файлов в хранилище
    COMMIT_ACCESS(true),

    // Управление связанными задачами
    MANAGE_RELATED_ISSUES(true),

    // Управление хранилищем
    MANAGE_REPOSITORY(true),

    // Просмотр трудозатрат
    VIEW_TIME_ENTRIES(true),

    // Учёт трудозатрат
    LOG_TIME(true),

    // Редактирование учёта времени
    EDIT_TIME_ENTRIES(true),

    // Редактирование собственного учёта времени
    EDIT_OWN_TIME_ENTRIES(true),

    // Управление типами действий для проекта
    MANAGE_PROJECT_ACTIVITIES(true),

    // Учитывать время других пользователей
    LOG_TIME_FOR_OTHER_USERS(true),

    // Импорт трудозатрат
    IMPORT_TIME_ENTRIES(true),

    // Просмотр Wiki
    VIEW_WIKI_PAGES(true),

    // Просмотр истории Wiki
    VIEW_WIKI_EDITS(true),

    // Экспорт wiki-страниц
    EXPORT_WIKI_PAGES(true),

    // Редактирование wiki-страниц
    EDIT_WIKI_PAGES(true),

    // Переименование wiki-страниц
    RENAME_WIKI_PAGES(true),

    // Удаление wiki-страниц
    DELETE_WIKI_PAGES(true),

    // Удаление прикреплённых файлов
    DELETE_WIKI_PAGES_ATTACHMENTS(true),

    // Блокирование wiki-страниц
    PROTECT_WIKI_PAGES(true),

    // Управление Wiki
    MANAGE_WIKI(true);

    public final Boolean Permissions;

    Permissions(Boolean permissions) {
        this.Permissions = permissions;
    }
}
