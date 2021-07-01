package ru.training.at.hw4.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonComponent extends AbstractComponent {

    @FindBy(className = "label-radio")
    List<WebElement> radioButtonsWebElements;

    public RadioButtonComponent(WebDriver driver) {
        super(driver);
    }

    public void selectRadioButton(String radioButtonName) {
        for (WebElement element : radioButtonsWebElements) {
            if (element.getText().equalsIgnoreCase(radioButtonName)) {
                element.click();
            }
        }
    }
}
