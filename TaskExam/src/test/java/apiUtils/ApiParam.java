package apiUtils;

public enum ApiParam {
    TEST_ID("testId"),
    CONTENT("content"),
    CONTENT_TYPE("contentType"),
    SID("SID"),
    PROJECT_NAME("projectName"),
    METHOD_NAME("methodName"),
    ENV("env"),
    TEST_NAME("testName"),
    PROJECT_ID("projectId");
    private final String apiParam;

    ApiParam(String apiParam) {
        this.apiParam = apiParam;
    }

    public String getApiaParam() {
        return apiParam;
    }
}

