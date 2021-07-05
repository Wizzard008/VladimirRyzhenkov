package ru.training.at.hw5.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsWebPage extends AbstractPage {

    @FindBy(className = "label-radio")
    List<WebElement> radioButtonsWebElements;

    @FindBy(className = "label-checkbox")
    List<WebElement> checkboxItemsWebElements;

    @FindBy(css = "div.info-panel-section > ul > li")
    List<WebElement> webpageLogItems;

    @FindBy(xpath = "//option[text()='Yellow']")
    WebElement yellowDropdownMenuItem;

    @FindBy(xpath = "//option[text()='Red']")
    WebElement redDropdownMenuItem;

    @FindBy(xpath = "//option[text()='Green']")
    WebElement greenDropdownMenuItem;

    @FindBy(xpath = "//option[text()='Blue']")
    WebElement blueDropdownMenuItem;

    public DifferentElementsWebPage(WebDriver driver) {
        super(driver);
    }

    public void selectRadioButton(String radioButtonName) {
        for (WebElement element : radioButtonsWebElements) {
            if (element.getText().equalsIgnoreCase(radioButtonName)) {
                element.click();
            }
        }
    }

    public void selectCheckboxItem(String checkboxItemName) {
        for (WebElement element : checkboxItemsWebElements) {
            if (element.getText().equalsIgnoreCase(checkboxItemName)) {
                element.click();
            }
        }
    }

    public String[] getEventLogItemsTexts() {
        return webpageLogItems.stream().map(WebElement::getText).toArray(String[]::new);
    }

    public void selectColor(String colorName) {
        switch (colorName.toUpperCase()) {
            case "RED": {
                redDropdownMenuItem.click();
                break;
            }
            case "GREEN": {
                greenDropdownMenuItem.click();
                break;
            }
            case "BLUE": {
                blueDropdownMenuItem.click();
                break;
            }
            default: {
                yellowDropdownMenuItem.click();
            }
        }
    }
}
