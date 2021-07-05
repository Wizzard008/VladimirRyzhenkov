package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.at.hw5.driver.WebDriverSingleton;

public class CucumberHook {

    @Before
    public void initDriver() {
        WebDriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        WebDriverSingleton.closeDriver();
    }
}
