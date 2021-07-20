package ru.training.at.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public interface TestsInit {
    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        openSite(JdiWebSite.class);
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
