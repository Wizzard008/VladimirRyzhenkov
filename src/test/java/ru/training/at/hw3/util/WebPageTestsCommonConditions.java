package ru.training.at.hw3.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebPageTestsCommonConditions {
    protected WebDriver driver;
    public static final String USER_LOGIN = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";
    protected String userLogin;
    protected String userPassword;

    public WebPageTestsCommonConditions() {
        userLogin = TestDataReader.getTestData(USER_LOGIN);
        userPassword = TestDataReader.getTestData(USER_PASSWORD);
        //        userLogin = "Roman";
        //        userPassword = "Jdi1234";
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

