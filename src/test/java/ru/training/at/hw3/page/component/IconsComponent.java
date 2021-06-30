package ru.training.at.hw3.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IconsComponent extends AbstractComponent {

    @FindBy(css = ".benefit-icon")
    List<WebElement> iconsImages;

    @FindBy(css = ".benefit-txt")
    List<WebElement> iconsTextsWebElements;

    public IconsComponent(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfImages() {
        return iconsImages.size();
    }

    public String[] getIconsTexts() {
        return iconsTextsWebElements.stream().map(WebElement::getText).toArray(String[]::new);
    }



}
