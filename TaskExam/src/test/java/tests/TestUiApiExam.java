package tests;

import apiUtils.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;
import page.PageAddProject;
import page.PageHome;
import page.PageNewTest;
import page.PageNexage;
import utils.*;

import java.time.LocalDateTime;
import java.util.List;

public class TestUiApiExam extends BaseTest{
    private final BrowserMethods browserMethods = new BrowserMethods();
    private final PageHome pageHome = new PageHome();
    private final PageNewTest pageNewTest = new PageNewTest();
    private final PageNexage pageNexage = new PageNexage();
    private final PageAddProject pageAddProject = new PageAddProject();
    private final ApiAppRequest apiAppRequest = new ApiAppRequest();
    private final CheckSortTests checkSortTests = new CheckSortTests();
    private final GenerateRandomText generateRandomText = new GenerateRandomText();
    private final EncodeUtil encodeUtil = new EncodeUtil();
    private final String nameEnv = System.getenv(TestDataConst.userDomain);
    private final String SID = generateRandomText.generatingLetters(TestDataConst.numberOfSymbols);
    private final String TEST_NAME = generateRandomText.generatingLetters(TestDataConst.numberOfSymbols);
    private final String METHOD_NAME = generateRandomText.generatingLetters(TestDataConst.numberOfSymbols);
    private final String PROJECT_NAME = generateRandomText.generatingLetters(TestDataConst.numberOfSymbols);
    private final String GENERATION_LOG = generateRandomText.generatingLetters(TestDataConst.numberOfSymbols);
    private final String CONTENT_TYPE = TestDataConst.contentType;
    private final String VARIANT_NUMBER = TestDataConst.variantNumber;
    private final String ID_TEST = TestDataConst.idTest;
    private final int LIST_LENGTH = 19;
    private final int TAB_ADD = 1;
    private final int TAB_HOME = 0;

    @Test
    public void TestExam() {
        pageHome.state().waitForDisplayed();
        String token = apiAppRequest.getToken(VARIANT_NUMBER);
        Cookie ck = new Cookie("token", token);
        browserMethods.addCookie(ck);
        browserMethods.refresh();
        Assert.assertEquals(pageHome.checkVersion(), "Version: 2", "version changed incorrectly");
        pageHome.pressButtonNexage();
        List<LocalDateTime> listTestsUi = pageNexage.getDateTests();
        List<LocalDateTime> ListTestsApi = checkSortTests.sortListDate(apiAppRequest.getListOfTestsInJson(ApiUrl.TEST_GET_JSON, ID_TEST)
                .getBody().getArray());
        Assert.assertTrue(checkSortTests.sortingCheckUi(listTestsUi, ListTestsApi, LIST_LENGTH),
                "list tests in ui not sorted descending");
        browserMethods.goBack();
        pageHome.pressButtonAdd();
        browserMethods.switchToTab(TAB_ADD);
        pageAddProject.enterProjectName(PROJECT_NAME);
        pageAddProject.pressButtonSaveProject();
        Assert.assertEquals(pageAddProject.checkSaveProject(), String.format("Project %s saved", PROJECT_NAME),
                "the project was not added");
        browserMethods.closeTab();
        browserMethods.switchToTab(TAB_HOME);
        browserMethods.refresh();
        Assert.assertTrue(pageHome.checkProjectName(PROJECT_NAME), "the project did not appear in the list");
        pageHome.pressButtonNewTest(PROJECT_NAME);
        String id = apiAppRequest.addTest(ApiUrl.TEST_PUT, SID, PROJECT_NAME, TEST_NAME, METHOD_NAME, nameEnv);
        apiAppRequest.addTestLog(ApiUrl.TEST_LOG, id, GENERATION_LOG);
        String scr = encodeUtil.screenshotToBase64(browserMethods.getScreenshot());
        apiAppRequest.addScreenshot(ApiUrl.TEST_ATTACHMENT, id, scr, CONTENT_TYPE);
        Assert.assertEquals(pageNewTest.checkAddNewTest(), TEST_NAME, "test not added");
    }
}
