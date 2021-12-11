package page;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.CheckTestUiUtil;

import java.util.List;

public class PageHome extends Form {
    private final CheckTestUiUtil checkTestUiUtil = new CheckTestUiUtil();
    private final static String pageHomeLocator = "container";

    public PageHome() {
        super(By.className(pageHomeLocator), "text box 'Reporting test portal. Version: 0'");
    }

    private final IButton buttonAdd = getElementFactory().getButton(By.xpath("//a[@href='addProject']"),
            "button add");
    private final ITextBox textBoxVersion = getElementFactory().getTextBox(By.xpath("//p[contains(@class,'text-muted text-center footer-text')]/span"),
            "text box version ");
    private final IButton buttonNexage = getElementFactory().getButton(By.xpath("//a[@href='allTests?projectId=1']"),
            "button nexage");

    public String checkVersion() {
        return textBoxVersion.getText();
    }

    public void pressButtonNexage() {
        buttonNexage.click();
    }

    public boolean checkProjectName(String nameProject) {
        List<IButton> buttonNewTest = getElementFactory().findElements(By.xpath("//a[contains(@class,'list-group-item')]"),
                ElementType.BUTTON);
        return checkTestUiUtil.checkProjectName(nameProject, buttonNewTest);
    }

    public void pressButtonNewTest(String nameProject) {
        List<IButton> buttonNewTest = getElementFactory().findElements(By.xpath("//a[contains(@class,'list-group-item')]"),
                ElementType.BUTTON);
        checkTestUiUtil.pressButtonProject(nameProject, buttonNewTest);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }
}
