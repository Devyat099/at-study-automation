package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.table_users.User;

public class UserRequests implements Create<User>{

    @Override
    public void create(User user) {

        String query = "INSERT INTO public.users" +
                "(id, login, hashed_password, firstname, lastname, " +
                "admin, status, last_login_on, language, auth_source_id, " +
                "created_on, updated_on, type, identity_url, mail_notification, " +
                "salt, must_change_passwd, passwd_changed_on)" +
                "VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";

        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                user.getLogin(),
                user.getHashedPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getIsAdmin(),
                user.getStatus().statusCode,
                user.getLastLoginOn(),
                user.getLanguage().languageCode,
                user.getAuthSourceId(),
                user.getCreatedOn(),
                user.getUpdatedOn(),
                user.getType(),
                user.getIdentityUrl(),
                user.getMailNotification().name().toLowerCase(),
                user.getSalt(),
                user.getMustChangePassword(),
                user.getPasswordChangedOn()
        ).get(0).get("id");
        user.setId(id);
    }

}
