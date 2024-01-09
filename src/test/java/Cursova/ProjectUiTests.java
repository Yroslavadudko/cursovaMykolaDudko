package Cursova;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.BasePage;

public class ProjectUiTests extends BasePage {
    @BeforeClass
    public static void setUp() {
        Configuration.baseUrl = "http://127.0.0.1";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    public void createProjectTest() {
        // Project creation
        loginAsAdmin();
        getNewProjectField().click();
        getFormNameProjectField().setValue("Project Dudko");
        getIdentifierProjectField().setValue("MYPROJECT");
        getColumnTaskProjectField().click();
        getFormTaskLimitField().setValue("5");
        getSaveField().click();
    }
}
