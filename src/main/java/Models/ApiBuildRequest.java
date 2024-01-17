package Models;

import lombok.*;

import static Base.BasePage.*;
@Getter
@Setter
@NoArgsConstructor

@Builder
public class ApiBuildRequest {




    private String buildCreateUserRequest() {
        return "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"createUser\",\n" +
                "    \"id\": " + USER_ID + ",\n" +
                "    \"params\": {\n" +
                "        \"username\": \"" + USER_API + "\",\n" +
                "        \"password\": \"" + PASSWORD_API + "\"\n" +
                "    }\n" +
                "}";
    }
    private String buildRemoveUserRequest() {
        return "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"removeUser\",\n" +
                "    \"id\": " + USER_ID + ",\n" +
                "    \"params\": {\n" +
                "        \"user_id\": " + 3 + "\n" +
                "    }\n" +
                "}";
    }

}
