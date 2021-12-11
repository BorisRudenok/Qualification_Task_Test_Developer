package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static aquality.selenium.browser.AqualityServices.getLogger;

public class ConfigManager {
    private static final String pathResources = "src/test/resources/";
    private static Properties PROPERTIESTestData;
    private static final String pathTestData = "testData.properties";
    private static final String pathConf = "conf.properties";
    private static Properties PROPERTIESConf;

    static {
        try (FileReader fileInputStreamTestData = new FileReader(String.format("%s%s", pathResources, pathTestData));
             FileReader fileInputStreamConf = new FileReader(String.format("%s%s", pathResources, pathConf))) {
            PROPERTIESConf = new Properties();
            PROPERTIESTestData = new Properties();
            PROPERTIESConf.load(fileInputStreamConf);
            PROPERTIESTestData.load(fileInputStreamTestData);
            PROPERTIESConf.putAll(PROPERTIESTestData);
        } catch (IOException e) {
            getLogger().info("file data failed", e);
        }
    }

    public static String getProperty(String key) {
        return PROPERTIESConf.getProperty(key);
    }

}
