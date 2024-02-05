package models.args.result;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String jsonrpc;
    private T result;
    private String error;
    private int id;

    public static <T> Result<T> of(Class<T> type) {
        return new Result<T>();
    }

    public int User_id() {
        if (result instanceof Integer) {
            return (Integer) result;
        } else {
            return 0;
        }
    }

    public int Project_id() {
        if (result instanceof Integer) {
            return (Integer) result;
        } else {
            return 0;
        }
    }
    public int Task_id() {
        if (result instanceof Integer) {
            return (Integer) result;
        } else {
            return 0;
        }
    }
}



