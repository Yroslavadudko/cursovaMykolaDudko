package api.models.dynamic;

import org.testng.annotations.DataProvider;

public class DynamicUserTests {
    @DataProvider(name = "userData")
    public Object[][] projectData() {
        return new Object[][]{
                {"MykolaDudko"},
        };
    }
}
