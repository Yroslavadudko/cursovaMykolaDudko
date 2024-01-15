package Base;

public class ProjectPage extends BasePage {
    public void createNewFullProject(){
        getNewProjectField().click();
        getFormNameProjectField().setValue("Project Dudko");
        getIdentifierProjectField().setValue("MYPROJECT");
        getColumnTaskProjectField().click();
        getFormTaskLimitField().setValue("5");
        getSaveField().click();
    }

}
