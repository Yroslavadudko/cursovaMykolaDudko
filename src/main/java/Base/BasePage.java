package Base;

import org.openqa.selenium.Cookie;
import lombok.*;

public class BasePage {
    @Getter
    public static final String BASE_URL = "http://127.0.0.1";
    public static final String BROWSER_SIZE = "1920x1080";
    public static final String HOME_PAGE = "/";
    public static final String USER = "admin";
    public static final String PASSWORD = "admin";
    public static final String API_LOGIN = "jsonrpc";
    public static final String API_TOKEN = "cc8da32fd10d691478cab74228d753a82d0eeff5aad37a95a06bcb9e1f2e";
    public static final String USER_API = "dudko_3879tt15";
    public static final String PASSWORD_API = "00230tt515";
    public static final int USER_ID = 23075515;
    public static final int PROJECT_ID = 123456789;
    public static final int TASK_ID = 987654321;
    public static final String INVALID_USER_PASSWORD = "invalid";
    public static final String LOGIN_ENDPOINT = "/login";
    public static final String API_ENDPOINT = "/jsonrpc.php";
    public static String authHeaderUser;
    private Cookie authToken;
}
