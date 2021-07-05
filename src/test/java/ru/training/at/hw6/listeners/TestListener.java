package ru.training.at.hw6.listeners;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw6.driver.WebDriverSingleton;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult testResult) {
        saveScreenshot("-test failure");
    }

    private void saveScreenshot(String message) {
        File screenCapture = ((TakesScreenshot) WebDriverSingleton
            .getDriver())
            .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                ".//target/screenshots/"
                    + getCurrentTimeAsString() + message
                    + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
