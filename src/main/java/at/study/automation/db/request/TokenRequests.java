package at.study.automation.db.request;

import at.study.automation.db.connection.PostgresConnection;
import at.study.automation.model.users.Token;
import at.study.automation.model.users.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class TokenRequests extends BaseRequests implements Create<Token>, ReadAll<Token> {

    private User user;

    @Override
    public void create(Token token) {

        String query = "INSERT INTO public.tokens\n" +
                "(id, user_id, \"action\", value, created_on, updated_on)\n" +
                "VALUES(DEFAULT, ?, ?, ?, ?, ?) RETURNING id;\n";

        Integer id = (Integer) PostgresConnection.INSTANCE.executeQuery(
                query,
                token.getUserId(),
                token.getAction().name().toLowerCase(),
                token.getValue(),
                token.getCreatedOn(),
                token.getUpdatedOn()).get(0).get("id");
        token.setId(id);

    }

    @Override
    public List<Token> readAll() {
        Integer userId = Objects.requireNonNull(user.getId());
        String query = "SELECT * from tokens WHERE user_id = ?";
        List<Map<String, Object>> queryResult = PostgresConnection.INSTANCE.executeQuery(
                query,
                userId
        );

        return queryResult.stream()
                .map(data -> from(data, user))
                .collect(Collectors.toList());
    }


    private Token from(Map<String, Object> data, User user) {
        Token token = new Token(user);
        token.setId((Integer) data.get("id"));
        token.setAction(
                Token.TokenType.valueOf(data.get("action").toString().toUpperCase())
        );
        token.setValue((String) data.get("value"));
        token.setCreatedOn(toLocalDate(data.get("created_on")));
        token.setUpdatedOn(toLocalDate(data.get("updated_on")));
        return token;
    }


}
