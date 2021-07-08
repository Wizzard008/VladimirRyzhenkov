package ru.training.at.hw6.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ColorSelectorComponent extends AbstractComponent {

    @FindBy(xpath = "//option[text()='Yellow']")
    WebElement yellowDropdownMenuItem;

    @FindBy(xpath = "//option[text()='Red']")
    WebElement redDropdownMenuItem;

    @FindBy(xpath = "//option[text()='Green']")
    WebElement greenDropdownMenuItem;

    @FindBy(xpath = "//option[text()='Blue']")
    WebElement blueDropdownMenuItem;

    public ColorSelectorComponent(WebDriver driver) {
        super(driver);
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
