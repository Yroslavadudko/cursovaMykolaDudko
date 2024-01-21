package api.models.args.result;

public class CreateResult {
    public static int userResult;
    public static int taskResult;
    public static int projectResult;
    public synchronized static int getUserResult() {
        return userResult;
    }

    public synchronized static void setUserResult(int value) {
        userResult = value;
    }

    public synchronized static int getTaskResult() {
        return taskResult;
    }

    public synchronized static void setTaskResult(int value) {
        taskResult = value;
    }

    public synchronized static int getProjectResult() {
        return projectResult;
    }

    public synchronized static void setProjectResult(int value) {
        projectResult = value;
    }
}
