package at.study.automation.model.role;

import at.study.automation.model.Creatable;
import at.study.automation.model.user.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Role extends Entity implements Creatable<Role>  {

    //private String name = "Devyat " + StringUtils.randomEnglishString(5); // Наименование Роли
    //private Integer position = (new Random()).nextInt(1999); // Позиция отображения в общем списке ролей
    //private Assignable assignable = Assignable.IS_ASSIGNABLE; // возможность назначить задачу для этой роли

    //private final Integer builtin = 0;

    private Permissions permissions = Permissions.ADD_ISSUES; // TODO enum Права доступа, которые доступны для роли может быть null

    //private IssuesVisibility issuesVisibility = IssuesVisibility.ALL_TASK_VISIBILITY; // Видимость задач (все задачи = all, только общие задачи = default, задачи созданные или назначенные пользователю = own)
    private String userVisibility = "all"; // members_of_visible_projects или all (видимость пользователей)
    private String timeEntriesVisibility = "all"; // Видимость трудозатрат ("все трудозатраты" = all "Только собственные трудозатраты" = own)

    //private RolesManaged allRolesManaged = RolesManaged.ALL_MANAGED; // управление участниками(все роли = "true"; при выборе радиобаттона = "false")


    private String settings; // TODO работа с задачами; (просмотр задач, добавление задач, редактирование задач, добавление примичаний, удаление задач)


    @Override
    public Role create() {
        //TODO c помощью sql запроса
        throw new UnsupportedOperationException();
    }

    }

