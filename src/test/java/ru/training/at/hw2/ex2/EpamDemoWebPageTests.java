package ru.training.at.hw2.ex2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EpamDemoWebPageTests extends WebPageTestsCommonConditions {

    @Test
    public void demoPageTests() {
        //1.Open test site by URL
        driver.get(HOMEPAGE_URL);

        //2. Assert Browser title
        String expectedTitle = "Home Page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        //3.Perform login
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.className("profile-photo"))).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.id("name"))).sendKeys(LOGIN_NAME);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.id("password"))).sendKeys(PASSWORD);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.id("login-button"))).click();

        //4. Assert Username is loggined
        String actualDisplayedUsername = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfElementLocated(By.id("user-name"))).getText();

        String expectedUsername = "ROMAN IOVLEV";
        Assert.assertEquals(actualDisplayedUsername, expectedUsername);

        //5.Open through the header menu Service -> Different Elements Page
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.xpath("//li[@class=\"dropdown\"]/*[@class=\"dropdown-toggle\"]"))).click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.xpath("//a[contains(@href,\"different-elements.html\")]"))).click();

        //6.Select checkboxes - Water, Wind
        List<WebElement> checkboxMenuItems = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By.className("label-checkbox")));
        for (WebElement el : checkboxMenuItems
        ) {
            if (el.getText().equalsIgnoreCase("Water")) {
                el.click();
            }
            if (el.getText().equalsIgnoreCase("Wind")) {
                el.click();
            }
        }

        //7.Select radio - Selen
        List<WebElement> radioMenuItems = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By.className("label-radio")));
        for (WebElement el : radioMenuItems
        ) {
            if (el.getText().equalsIgnoreCase("Selen")) {
                el.click();
            }
        }

        //8.Select in dropdown - Yellow
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.xpath("//option[text()=\"Yellow\"]"))).click();

        //9.Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value
        Assert.assertTrue(driver.getPageSource().contains("Colors: value changed to Yellow"));
        Assert.assertTrue(driver.getPageSource().contains("metal: value changed to  Selen"));
        Assert.assertTrue(driver.getPageSource().contains("Wind: condition changed to true"));
        Assert.assertTrue(driver.getPageSource().contains("Water: condition changed to true"));
    }
}
