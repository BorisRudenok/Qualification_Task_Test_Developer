package utils;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private final BrowserMethods browserMethods = new BrowserMethods();
    private final UrlUtil urlUtil = new UrlUtil();

    @BeforeClass
    public void setUp() {
        browserMethods.maximizeWindow();
        browserMethods.goToUrl(urlUtil.getUrlBasicAuth(TestDataConst.login, TestDataConst.pass, TestDataConst.transferProtocol, ConfigConst.urlExam));
    }

    @AfterClass
    public void out() {
        browserMethods.quitDriver();
    }
}