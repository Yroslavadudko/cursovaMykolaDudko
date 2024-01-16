package Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    private String user;
    private String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
