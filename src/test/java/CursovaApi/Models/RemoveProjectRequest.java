package CursovaApi.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoveProjectRequest {
    private String jsonrpc;
    private String method;
    private long id;
    private RemoveProjectRequest.ParamsRemote params;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ParamsRemote {
        private int project_id;
    }
}
