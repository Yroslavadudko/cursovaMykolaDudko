package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static Properties properties;

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("BASE_URL", "http://127.0.0.1");
    }

    public static String getBrowserSize() {
        return properties.getProperty("BROWSER_SIZE", "1920x1080");
    }

    public static String getHomePage(){
        return properties.getProperty("HOME_PAGE", "/");
    }
    public static String getUser(){
        return properties.getProperty("USER", "admin");
    }
    public static String getPassword(){
        return properties.getProperty("PASSWORD", "admin");
    }
    public static String getInvalidUserPassword(){
        return properties.getProperty("INVALID_USER_PASSWORD", "invalid");
    }
    public static String getUserApi(){
        return properties.getProperty("USER_API", "dudko_3879tt15");
    }
    public static String getPasswordApi(){
        return properties.getProperty("PASSWORD_API", "00230tt515");
    }
    public static String getApiLogin(){
        return properties.getProperty("API_LOGIN", "jsonrpc");
    }
    public static String getApiToken(){
        return properties.getProperty("API_TOKEN", "cc8da32fd10d691478cab74228d753a82d0eeff5aad37a95a06bcb9e1f2e");
    }
    public static String getApiEndpoint(){
        return properties.getProperty("API_ENDPOINT", "/jsonrpc.php");
    }
    public static int getUserId(){
        return Integer.parseInt(properties.getProperty("USER_ID"));
    }
    public static int getProjectId(){
        return Integer.parseInt(properties.getProperty("PROJECT_ID"));
    }
    public static int getTaskId(){
        return Integer.parseInt(properties.getProperty("TASK_ID"));
    }
}
