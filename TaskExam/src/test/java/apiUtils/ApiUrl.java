package apiUtils;

public enum ApiUrl {
    TOKEN("/token/get"),
    TEST_GET_JSON("/test/get/json"),
    TEST_PUT("/test/put"),
    TEST_LOG("/test/put/log"),
    TEST_ATTACHMENT("/test/put/attachment");
    private final String method;

    ApiUrl(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
