package page;

import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class PageNewTest extends Form {
    private final int NUMBER_OF_TEST = 0;
    private final static String pageNewTestLocator = "allTests";
    public PageNewTest() {
        super(By.id(pageNewTestLocator), "table all tests");
    }

    public String checkAddNewTest() {
        List<ITextBox> nameTest = getElementFactory().findElements(By.xpath("//table[@id='allTests']//tbody//tr//td//a[@href][1]"),
                ElementType.TEXTBOX,
                ElementsCount.MORE_THEN_ZERO);
        return nameTest.get(NUMBER_OF_TEST).getText();
    }
}
