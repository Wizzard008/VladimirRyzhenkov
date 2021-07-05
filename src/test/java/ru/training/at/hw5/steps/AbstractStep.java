package ru.training.at.hw5.steps;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.page.component.DifferentElementsWebPage;
import ru.training.at.hw5.page.component.GdiIndexWebPage;
import ru.training.at.hw5.page.component.UserTableWebPage;

public abstract class AbstractStep {

    public static final String USER_LOGIN_KEY = "testdata.user.name";
    public static final String USER_PASSWORD_KEY = "testdata.user.password";

    protected WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected GdiIndexWebPage gdiIndexWebPage;
    protected DifferentElementsWebPage differentElementsWebPage;
    protected UserTableWebPage userTableWebPage;

    protected static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    protected AbstractStep() {
        this.driver = WebDriverSingleton.getDriver();
        gdiIndexWebPage = new GdiIndexWebPage(driver);
        differentElementsWebPage = new DifferentElementsWebPage(driver);
        userTableWebPage = new UserTableWebPage(driver);
    }
}
