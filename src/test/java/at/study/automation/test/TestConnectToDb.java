package at.study.automation.test;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.db.request.EmailRequests;
import at.study.automation.db.request.UserRequests;
import at.study.automation.model.user.Email;
import at.study.automation.model.user.User;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class TestConnectToDb {

    @Test
    @SneakyThrows
    public void testConnect() {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://edu-at.dfu.i-teco.ru:5432/db";
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", "redmine_user");
        connectionProperties.setProperty("password", "redmine_pass");
        Connection connection = DriverManager.getConnection(url, connectionProperties);

        String query = "SELECT * FROM tokens";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        List<Map<String, Object>> result = new ArrayList<>();


        while (rs.next()) {
            Map<String, Object> oneResult = new TreeMap<>();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String key = rs.getMetaData().getColumnName(i);
                Object value = rs.getObject(i);
                oneResult.put(key, value);

            }
            result.add(oneResult);
        }

        System.out.println();
    }

    @Test
    public void postgresTest(){
        String query = "SELECT * FROM users WHERE id = ?";
        List<Map<String, Object>> result = PostgresConnection.INSTANCE.executeQuery(query, 2);

    }


    @Test
    public void emailCreate(){
        User user = new User();
        Email email = new Email(user);
        email.setUserId(9);

        new EmailRequests().create(email);
    }


    @Test
    public void userCreateTest() {
        User user = new User();
        new UserRequests().create(user);

    }
}
