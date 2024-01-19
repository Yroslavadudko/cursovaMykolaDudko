package api.models.dynamic;

import org.testng.annotations.DataProvider;

public class DynamicProjectTests {
    @DataProvider(name = "projectData")
    public Object[][] projectData() {
        return new Object[][]{
                {"ProjectDudko1"},
//                {"ProjectDudko2"},
//                {"ProjectDudko3"},
//                {"ProjectDudko4"},
//                {"ProjectDudko5"}
        };
    }
}
