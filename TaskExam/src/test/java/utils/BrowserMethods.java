package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.openqa.selenium.Cookie;

public class BrowserMethods {
    private final Browser browser = AqualityServices.getBrowser();

    public void goToUrl(String url) {
        browser.goTo(url);
    }

    public void maximizeWindow() {
        browser.maximize();
    }

    public void addCookie(Cookie ck) {
        browser.getDriver().manage().addCookie(ck);
    }

    public void refresh() {
        browser.refresh();
    }

    public void goBack() {
        browser.goBack();
    }

    public void switchToTab(int tabNumber) {
        browser.tabs().switchToTab(tabNumber);
    }

    public void closeTab() {
        browser.tabs().closeTab();
    }

    public void quitDriver() {
        browser.quit();
    }

    public byte[] getScreenshot() {
        return browser.getScreenshot();
    }
}
