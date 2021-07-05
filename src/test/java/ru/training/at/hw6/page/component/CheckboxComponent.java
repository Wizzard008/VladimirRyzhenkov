package ru.training.at.hw6.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxComponent extends AbstractComponent {

    @FindBy(className = "label-checkbox")
    List<WebElement> checkboxItemsWebElements;

    public CheckboxComponent(WebDriver driver) {
        super(driver);
    }

    public void selectCheckboxItem(String checkboxItemName) {
        for (WebElement element : checkboxItemsWebElements) {
            if (element.getText().equalsIgnoreCase(checkboxItemName)) {
                element.click();
            }
        }
    }
}
