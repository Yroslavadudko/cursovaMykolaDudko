package api.models.args;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

public class UserInfo {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateUserRequest {
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
            private String name;
            private String role;
            private String email;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RemoveUserRequest {
        private String jsonrpc;
        private String method;
        private long id;
        private ParamsRemote params;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public static class ParamsRemote {
            private int user_id;
        }
    }
}
