package utils;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckTestUiUtil {
    private final ParsDate parsDate = new ParsDate();

    public boolean checkProjectName(String nameProject, List<IButton> element) {
        String getNameProject;
        for (int i = 0; i <= element.size() - 1; i++) {
            getNameProject = element.get(i).getText();
            if (getNameProject.equals(nameProject)) {
                return true;
            }
        }
        return false;
    }

    public void pressButtonProject(String nameProject, List<IButton> element) {
        String getNameProject;
        for (int i = 0; i <= element.size() - 1; i++) {
            getNameProject = element.get(i).getText();
            if (getNameProject.equals(nameProject)) {
                element.get(i).click();
                return;
            }
        }
    }

    public List<LocalDateTime> getDateTests(List<ITextBox> element) {
        List<LocalDateTime> arrayListDate = new ArrayList<>();
        for (int i = 0; i <= element.size() - 1; i++) {
            LocalDateTime localDateTime = parsDate.getDate(element.get(i).getText());
            arrayListDate.add(localDateTime);
        }
        return arrayListDate;
    }
}
