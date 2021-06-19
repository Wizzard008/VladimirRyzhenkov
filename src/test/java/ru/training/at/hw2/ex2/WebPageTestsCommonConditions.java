package ru.training.at.hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebPageTestsCommonConditions {
    protected WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;
    protected static final String LOGIN_NAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";
    protected static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}

