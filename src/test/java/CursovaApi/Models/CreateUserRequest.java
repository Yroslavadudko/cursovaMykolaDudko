package CursovaApi.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequest {
    private String jsonrpc;
    private String method;
    private long id;
    private ParamsCreate params;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ParamsCreate {
        private String username;
        private String password;
    }
}
