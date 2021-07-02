package ru.training.at.hw4.page;

import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.page.component.CheckboxComponent;
import ru.training.at.hw4.page.component.ColorSelectorComponent;
import ru.training.at.hw4.page.component.EventLogComponent;
import ru.training.at.hw4.page.component.HeaderComponent;
import ru.training.at.hw4.page.component.IconsComponent;
import ru.training.at.hw4.page.component.LeftSideMenuComponent;
import ru.training.at.hw4.page.component.RadioButtonComponent;

public class AbstractPage {
    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    protected HeaderComponent headerMenu;
    protected IconsComponent icons;
    protected LeftSideMenuComponent leftSideMenu;
    protected CheckboxComponent checkbox;
    protected RadioButtonComponent radioButton;
    protected ColorSelectorComponent colorSelector;
    protected EventLogComponent eventLog;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        headerMenu = new HeaderComponent(driver);
        leftSideMenu = new LeftSideMenuComponent(driver);
        checkbox = new CheckboxComponent(driver);
        radioButton = new RadioButtonComponent(driver);
        colorSelector = new ColorSelectorComponent(driver);
        eventLog = new EventLogComponent(driver);
        icons = new IconsComponent(driver);
    }
}
