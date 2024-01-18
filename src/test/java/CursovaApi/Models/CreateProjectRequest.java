package CursovaApi.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProjectRequest {
    private String jsonrpc;
    private String method;
    private long id;
    private CreateProjectRequest.ParamsCreate params;

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
