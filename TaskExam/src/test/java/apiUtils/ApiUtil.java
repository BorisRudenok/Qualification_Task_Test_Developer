package apiUtils;

import kong.unirest.*;
import java.util.Map;


public class ApiUtil {
    private final String baseUrl;

    public ApiUtil(String baseUrl) {
        this.baseUrl = baseUrl;
        Unirest.config().defaultBaseUrl(baseUrl);
    }

    public HttpRequestWithBody post(String route, Map<String, Object> params) {
        return Unirest.post(route).queryString(params);
    }

    public HttpResponse postToken(String requestPath) {
        HttpResponse<String> response = Unirest.post(requestPath).asString();
        Unirest.shutDown();
        return response;
    }
}
