package ui;

import Base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Base.ProjectPage;

public class ProjectUiTests extends ProjectPage {
    @BeforeClass
    public static void setUp() {
        BaseTest.setUpClass();
    }
    @Test
    public void createProjectTest() {
        // Project creation
        loginAsAdmin();
        createNewFullProject();
        // Add project test
        BaseTest.homePage();
        getNewProjectField().click();
        getFormNameProjectField().setValue("Add Project Test");
        getIdentifierProjectField().setValue("TEST");
        getSaveField().click();
    }
}
