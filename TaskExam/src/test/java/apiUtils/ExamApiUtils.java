package apiUtils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import utils.ConfigConst;

import java.util.Map;

public class ExamApiUtils extends ApiUtil {
    public ExamApiUtils() {
        super(ConfigConst.apiBaseUrl);
    }

    public HttpResponse<JsonNode> postExam(ApiUrl method, Map<String, Object> params) {
        return post(method.getMethod(), params).asJson();
    }
}
