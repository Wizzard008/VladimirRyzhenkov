package ru.training.at.hw4.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw4.driver.WebDriverSingleton;

public class AllureAttachmentListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
    private byte[] attachScreenShot() {
        return ((TakesScreenshot) WebDriverSingleton
            .getDriver())
            .getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        attachScreenShot();
    }
}
