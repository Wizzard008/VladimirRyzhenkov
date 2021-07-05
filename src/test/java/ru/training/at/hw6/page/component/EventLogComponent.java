package ru.training.at.hw6.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventLogComponent extends AbstractComponent {

    @FindBy(css = "div.info-panel-section > ul > li")
    List<WebElement> webpageLogItems;

    public EventLogComponent(WebDriver driver) {
        super(driver);
    }

    public String[] getEventLogItemsTexts() {
        return webpageLogItems.stream().map(WebElement::getText).toArray(String[]::new);
    }
}
