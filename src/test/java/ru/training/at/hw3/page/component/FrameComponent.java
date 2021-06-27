package ru.training.at.hw3.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameComponent extends AbstractComponent {

    @FindBy(id = "frame")
    WebElement iframe;

    @FindBy(id = "frame-button")
    WebElement frameButton;

    public FrameComponent(WebDriver driver) {
        super(driver);
    }

    public boolean frameIsAvailable() {
        return iframe.isDisplayed();
    }

    public boolean frameButtonIsAvailable() {
        return frameButton.isDisplayed();
    }

    public void switchToFrame() {
        driver.switchTo().frame(iframe);
    }
}
