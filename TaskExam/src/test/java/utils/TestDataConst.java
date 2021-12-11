package utils;

public class TestDataConst {
    public static final String transferProtocol = ConfigManager.getProperty("transferProtocol");
    public static final String login = ConfigManager.getProperty("login");
    public static final String pass = ConfigManager.getProperty("password");
    public static final String time = ConfigManager.getProperty("time");
    public static final String userDomain = ConfigManager.getProperty("env");
    public static final int numberOfSymbols = Integer.parseInt(ConfigManager.getProperty("numberOfSymbolsForRandom"));
    public static final String contentType = ConfigManager.getProperty("contentType");
    public static final String variantNumber = ConfigManager.getProperty("variantNumber");
    public static final String idTest = ConfigManager.getProperty("idTest");
}
