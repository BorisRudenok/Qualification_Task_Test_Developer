package page;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PageAddProject extends Form {
    private static final String pageAddProjectLocator = "//label[@for='projectName']";
    public PageAddProject() {
        super(By.xpath(pageAddProjectLocator), "label project name");
    }

    private final ITextBox textBoxEnterProjectName = getElementFactory().getTextBox(By.id("projectName"),
            "text box enter project name");
    private final IButton buttonSaveProject = getElementFactory().getButton(By.xpath("//button[@type='submit']"),
            "button save project");
    private final ILabel labelCheckSave = getElementFactory().getLabel(By.xpath("//div[@class='alert alert-success']"),
            "label check save");

    public void enterProjectName(String nameProject) {
        textBoxEnterProjectName.sendKeys(nameProject);
    }

    public void pressButtonSaveProject() {
        buttonSaveProject.click();
    }

    public String checkSaveProject() {
        return labelCheckSave.getText();
    }
}
