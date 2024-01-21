package ui.steps;

import static Base.BasePage.*;
import static com.codeborne.selenide.Selenide.open;
import static ui.elements.LoginElements.*;
public class LoginPage{
    public static void loginAsAdmin() {
        open(HOME_PAGE);
        userField().setValue(USER);
        passwordField().setValue(PASSWORD);
        rememberMyField();
        signInButton().click();
    }
}


