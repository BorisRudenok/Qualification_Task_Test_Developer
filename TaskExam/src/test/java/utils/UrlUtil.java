package utils;

public class UrlUtil {
    public String getUrlBasicAuth(String login, String password, String transferProtocol, String url) {
        return String.format("%s%s:%s@%s", transferProtocol, login, password, url);
    }
}
