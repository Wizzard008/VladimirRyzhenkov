package ru.training.at.hw4.util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.training.at.hw4.driver.WebDriverSingleton;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.AssertionStep;

public class BaseSeleniumTest {
    protected WebDriver driver;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;
    public static final String USER_LOGIN = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";
    public static final String USER_CREDENTIALS = "testdata.user.credentials";
    protected String userLogin;
    protected String userPassword;
    protected String expectedUsername;

    public BaseSeleniumTest() {
        userLogin = TestDataReader.getTestData(USER_LOGIN);
        userPassword = TestDataReader.getTestData(USER_PASSWORD);
        expectedUsername = TestDataReader.getTestData(USER_CREDENTIALS);
    }

    @BeforeMethod
    public void setUp(ITestContext testContext) {
        driver = WebDriverSingleton.getDriver();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        testContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver = null;
        WebDriverSingleton.closeDriver();
    }
}

