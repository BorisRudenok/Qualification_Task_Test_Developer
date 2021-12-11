package apiUtils;

import apiModels.JsonResponse;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.util.HashMap;
import java.util.Map;

public class ApiAppRequest {
    private final ExamApiUtils examApiUtils = new ExamApiUtils();

    public String getToken(String variant) {
        String request = String.format("%s?variant=%s", ApiUrl.TOKEN.getMethod(), variant);
        HttpResponse jsonResponse = examApiUtils.postToken(request);
        return jsonResponse.getBody().toString();
    }

    public JsonResponse getListOfTestsInJson(ApiUrl method, String id) {
        Map<String, Object> params = new HashMap<>();
        params.put(ApiParam.PROJECT_ID.getApiaParam(), id);
        HttpResponse<JsonNode> response = examApiUtils.postExam(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public String addTest(ApiUrl method, String sid, String projectName, String testName, String methodName,
                          String env) {
        Map<String, Object> params = new HashMap<>();
        params.put(ApiParam.SID.getApiaParam(), sid);
        params.put(ApiParam.PROJECT_NAME.getApiaParam(), projectName);
        params.put(ApiParam.TEST_NAME.getApiaParam(), testName);
        params.put(ApiParam.METHOD_NAME.getApiaParam(), methodName);
        params.put(ApiParam.ENV.getApiaParam(), env);
        HttpResponse<JsonNode> response = examApiUtils.postExam(method, params);
        return response.getParsingError().get().getOriginalBody();
    }

    public JsonResponse addTestLog(ApiUrl method, String idTest, String logs) {
        Map<String, Object> params = new HashMap<>();
        params.put(ApiParam.TEST_ID.getApiaParam(), idTest);
        params.put(ApiParam.CONTENT.getApiaParam(), logs);
        HttpResponse<JsonNode> response = examApiUtils.postExam(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

    public JsonResponse addScreenshot(ApiUrl method, String idTest, String screenshotBase64, String contentType) {
        Map<String, Object> params = new HashMap<>();
        params.put(ApiParam.TEST_ID.getApiaParam(), idTest);
        params.put(ApiParam.CONTENT.getApiaParam(), screenshotBase64);
        params.put(ApiParam.CONTENT_TYPE.getApiaParam(), contentType);
        HttpResponse<JsonNode> response = examApiUtils.postExam(method, params);
        return new JsonResponse(response.getStatus(), response.getBody());
    }

}
