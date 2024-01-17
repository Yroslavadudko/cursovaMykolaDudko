package CursovaApi.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {
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
            private String title;
            private int project_id;
            private String color_id;
        }
    }

