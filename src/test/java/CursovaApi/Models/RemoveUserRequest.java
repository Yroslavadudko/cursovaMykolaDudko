package CursovaApi.Models;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoveUserRequest {
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




//    private long userId;
//    private String title;
//    private int project_id;
//    private String color_id;
//    private int task_id;
    }
}
