package ru.training.at.hw3.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebPageTestsCommonConditions {
    protected WebDriver driver;
    public static final String USER_LOGIN = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";
    public static final String USER_CREDENTIALS = "testdata.user.credentials";
    protected String userLogin;
    protected String userPassword;
    protected String expectedUsername;

    public WebPageTestsCommonConditions() {
        userLogin = TestDataReader.getTestData(USER_LOGIN);
        userPassword = TestDataReader.getTestData(USER_PASSWORD);
        expectedUsername = TestDataReader.getTestData(USER_CREDENTIALS);
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver = null;
        DriverSingleton.closeDriver();
    }
}

