package at.study.automation.model.role;

import at.study.automation.model.Creatable;
import at.study.automation.model.Entity;
import at.study.automation.utils.StringUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
@Setter
@Getter
public class Role extends Entity implements Creatable<Role>  {

    // Наименование Роли
    private String name = "Devyat " + StringUtils.randomEnglishString(5);

    // Позиция отображения в общем списке ролей
    private Integer position = (new Random()).nextInt(1999);

    // возможность назначить задачу для этой роли
    private Assignable assignable = Assignable.IS_ASSIGNABLE;

    private final Integer builtin = 0;

    // enum Права доступа, которые доступны для роли может быть null
    private List<Permissions> permissions = new ArrayList<>();

    // Видимость задач (все задачи = all, только общие задачи = default, задачи созданные или назначенные пользователю = own)
    private IssuesVisibility issuesVisibility = IssuesVisibility.ALL_TASK_VISIBILITY;

    // видимость пользователей members_of_visible_projects или all
    private UserVisibility userVisibility = UserVisibility.ALL;

    // Видимость трудозатрат ("все трудозатраты" = all "Только собственные трудозатраты" = own)
    private TimeEntriesVisibility timeEntriesVisibility = TimeEntriesVisibility.ALL;

    // управление участниками(все роли = "true"; при выборе радиобаттона = "false")
    private RolesManaged allRolesManaged = RolesManaged.ALL_MANAGED;


    private List<Settings> settings = new ArrayList<>(); //  работа с задачами; (просмотр задач, добавление задач, редактирование задач, добавление примичаний, удаление задач)


    @Override
    public Role create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }

    }

