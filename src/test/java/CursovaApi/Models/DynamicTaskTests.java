package CursovaApi.Models;

import org.testng.annotations.DataProvider;

public class DynamicTaskTests {
    @DataProvider(name = "taskData")
    public Object[][] projectData() {
        return new Object[][]{
                {"TaskDudko1"},
//                {"TaskDudko2"},
//                {"TaskDudko3"},
//                {"TaskDudko4"},
//                {"TaskDudko5"}
        };
    }
}
