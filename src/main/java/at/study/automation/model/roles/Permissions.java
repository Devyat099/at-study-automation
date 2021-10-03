package at.study.automation.model.roles;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public enum Permissions {
    // Создание проекта
    ADD_PROJECT(),

    // Редактирование проектов
    EDIT_PROJECT( ),

    // Закрывать / открывать проекты
    CLOSE_PROJECT( ),

    // Выбор модулей проекта
    SELECT_PROJECT_MODULES( ),

    // Управление участниками
    MANAGE_MEMBERS( ),

    // Управление версиями
    MANAGE_VERSIONS( ),

    // Создание подпроектов
    ADD_SUBPROJECTS( ),

    // Управление общими запросами
    MANAGE_PUBLIC_QUERIES( ),

    // Сохранение запросов
    SAVE_QUERIES( ),

    // Просмотр сообщений
    VIEW_MESSAGES( ),

    // Отправка сообщений
    ADD_MESSAGES( ),

    // Редактирование сообщений
    EDIT_MESSAGES( ),

    // Редактирование собственных сообщений
    EDIT_OWN_MESSAGES( ),

    // Удаление сообщений
    DELETE_MESSAGES( ),

    // Удаление собственных сообщений
    DELETE_OWN_MESSAGES( ),

    // Управление форумами
    MANAGE_BOARDS( ),

    // Просмотр календаря
    VIEW_CALENDAR( ),

    // Просмотр документов
    VIEW_DOCUMENTS( ),

    // Добавить документы
    ADD_DOCUMENTS( ),

    // Редактировать документы
    EDIT_DOCUMENTS( ),

    // Удалить документы
    DELETE_DOCUMENTS( ),

    // Просмотр файлов
    VIEW_FILES( ),

    // Управление файлами
    MANAGE_FILES( ),

    // Просмотр диаграммы Ганта
    VIEW_GANTT( ),

    // Просмотр задач
    VIEW_ISSUES( ),

    // Добавление задач
    ADD_ISSUES( ),

    // Редактирование задач
    EDIT_ISSUES( ),

    // Редактировать свои задачи
    EDIT_OWN_ISSUES( ),

    // Копирование задач
    COPY_ISSUES( ),

    // Управление связыванием задач
    MANAGE_ISSUE_RELATIONS( ),

    // Управление подзадачами
    MANAGE_SUBTASKS( ),

    //  Установление видимости (общая/частная) для задач
    SET_ISSUES_PRIVATE( ),

    // Установление видимости (общая/частная) для собственных задач
    SET_OWN_ISSUES_PRIVATE( ),

    // Добавление примечаний
    ADD_ISSUE_NOTES( ),

    // Редактирование примечаний
    EDIT_ISSUE_NOTES( ),

    // Редактирование собственных примечаний
    EDIT_OWN_ISSUE_NOTES( ),

    // Просмотр приватных комментариев
    VIEW_PRIVATE_NOTES( ),

    // Размещение приватных комментариев
    SET_NOTES_PRIVATE( ),

    // Удаление задач
    DELETE_ISSUES( ),

    // Просмотр списка наблюдателей
    VIEW_ISSUE_WATCHERS( ),

    // Добавление наблюдателей
    ADD_ISSUE_WATCHERS( ),

    // Удаление наблюдателей
    DELETE_ISSUE_WATCHERS( ),

    // Импорт задач
    IMPORT_ISSUES( ),

    // Управление категориями задач
    MANAGE_CATEGORIES( ),

    // Просмотр новостей
    VIEW_NEWS( ),

    // Управление новостями
    MANAGE_NEWS( ),

    // Комментирование новостей
    COMMENT_NEWS( ),

    // Просмотр изменений хранилища
    VIEW_CHANGESETS( ),

    // Просмотр хранилища
    BROWSE_REPOSITORY( ),

    // Изменение файлов в хранилище
    COMMIT_ACCESS( ),

    // Управление связанными задачами
    MANAGE_RELATED_ISSUES( ),

    // Управление хранилищем
    MANAGE_REPOSITORY( ),

    // Просмотр трудозатрат
    VIEW_TIME_ENTRIES( ),

    // Учёт трудозатрат
    LOG_TIME( ),

    // Редактирование учёта времени
    EDIT_TIME_ENTRIES( ),

    // Редактирование собственного учёта времени
    EDIT_OWN_TIME_ENTRIES( ),

    // Управление типами действий для проекта
    MANAGE_PROJECT_ACTIVITIES( ),

    // Учитывать время других пользователей
    LOG_TIME_FOR_OTHER_USERS( ),

    // Импорт трудозатрат
    IMPORT_TIME_ENTRIES( ),

    // Просмотр Wiki
    VIEW_WIKI_PAGES( ),

    // Просмотр истории Wiki
    VIEW_WIKI_EDITS( ),

    // Экспорт wiki-страниц
    EXPORT_WIKI_PAGES( ),

    // Редактирование wiki-страниц
    EDIT_WIKI_PAGES( ),

    // Переименование wiki-страниц
    RENAME_WIKI_PAGES( ),

    // Удаление wiki-страниц
    DELETE_WIKI_PAGES( ),

    // Удаление прикреплённых файлов
    DELETE_WIKI_PAGES_ATTACHMENTS( ),

    // Блокирование wiki-страниц
    PROTECT_WIKI_PAGES( ),

    // Управление Wiki
    MANAGE_WIKI( );


}
