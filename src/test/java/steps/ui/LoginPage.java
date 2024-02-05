package steps.ui;

import config.Config;
import static com.codeborne.selenide.Selenide.open;
import static elements.LoginElements.*;


public class LoginPage{
    public static void loginAsAdmin() {
        open(Config.getHomePage());
        userField().setValue(Config.getUser());
        passwordField().setValue(Config.getPassword());
        rememberMyField();
        signInButton().click();
    }
}


