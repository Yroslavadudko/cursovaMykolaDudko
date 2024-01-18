package CursovaApi.Models;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
