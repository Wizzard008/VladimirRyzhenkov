package ru.training.at.hw4.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenuComponent extends AbstractComponent {


    @FindBy(css = "#mCSB_1_container > ul > li > a > span")
    List<WebElement> leftSectionMenuWebElements;

    public LeftSideMenuComponent(WebDriver driver) {
        super(driver);
    }

    public String[] getLeftSectionMenuTexts() {
        return leftSectionMenuWebElements.stream().map(WebElement::getText).toArray(String[]::new);
    }
}
