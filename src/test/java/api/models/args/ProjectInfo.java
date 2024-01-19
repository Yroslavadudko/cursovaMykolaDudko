package api.models.args;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

public class ProjectInfo {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class CreateProjectRequest {
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
            private String name;
            private String description;
            private String start_date;
            private String end_date;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class RemoveProjectRequest {
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
            private int project_id;
        }
    }
}
