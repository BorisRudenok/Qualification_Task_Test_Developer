package page;

import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.CheckTestUiUtil;

import java.time.LocalDateTime;
import java.util.List;

public class PageNexage extends Form {
    private final CheckTestUiUtil checkTestUiUtil = new CheckTestUiUtil();
    private final static String pageNexageLocator = "allTests";

    public PageNexage() {
        super(By.id(pageNexageLocator), "table all tests");
    }

    public List<LocalDateTime> getDateTests() {
        List<ITextBox> nameTest = getElementFactory().findElements(By.xpath("//table[@id='allTests']//tbody//tr//td[4]"),
                ElementType.TEXTBOX,
                ElementsCount.MORE_THEN_ZERO);
        return checkTestUiUtil.getDateTests(nameTest);
    }
}
