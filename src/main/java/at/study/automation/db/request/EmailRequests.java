package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.users.Email;
import at.study.automation.model.users.User;

import java.util.List;
import java.util.Map;

public class EmailRequests extends BaseRequests implements Create<Email>, Delete, Read<Email> {

    private User user;


    @Override
    public void create(Email email) {
        String query = "INSERT INTO public.email_addresses\n" +
                "(id, user_id, address, is_default, \"notify\", created_on, updated_on)\n" +
                "VALUES(DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING id;\n";
        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                email.getUserId(),
                email.getAddress(),
                email.getIsDefault(),
                email.getNotify(),
                email.getCreatedOn(),
                email.getUpdatedOn()).get(0).get("id");
        email.setId(id);
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM public.users WHERE id = ?";
        PostgresConnection.INSTANCE.executeQuery(query, id);
    }

    @Override
    public Email read(Integer id) {
        String query = "SELECT * FROM public.email_addresses WHERE id = ?";
        List<Map<String, Object>> queryResult = PostgresConnection.INSTANCE.executeQuery(query, id);
        return from(queryResult.get(0), user);
    }
//TODO в порядок метод
    private Email from(Map<String, Object> data, User user) {
        return (Email) new Email(user)
                .setAddress((String) data.get("address"))
                .setIsDefault((Boolean) data.get("is_default"))
                .setUpdatedOn(toLocalDate(data.get("updated_on")))
                .setNotify((Boolean) data.get("notify"))
                .setCreatedOn(toLocalDate(data.get("created_on")))
                .setId((Integer) data.get("id"));
    }
}
