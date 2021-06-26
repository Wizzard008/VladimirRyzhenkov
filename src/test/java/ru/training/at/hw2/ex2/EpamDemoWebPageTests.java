package ru.training.at.hw2.ex2;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw2.util.WebPageTestsCommonConditions;

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
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(By.className("profile-photo")))
            .click();

        String userLogin = "Roman";
        String userPassword = "Jdi1234";
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(By.id("name")))
            .sendKeys(userLogin);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(By.id("password")))
            .sendKeys(userPassword);

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(By.id("login-button")))
            .click();

        //4. Assert Username is loggined
        String actualDisplayedUsername = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")))
            .getText();

        String expectedUsername = "ROMAN IOVLEV";
        Assert.assertEquals(actualDisplayedUsername, expectedUsername);

        //5.Open through the header menu Service -> Different Elements Page
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("[class=\"dropdown-toggle\"]")))
            .click();

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,\"different-elements.html\")]")))
            .click();

        //6.Select checkboxes - Water, Wind
        List<WebElement> checkboxMenuItems = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By.className("label-checkbox")));
        for (WebElement el : checkboxMenuItems) {
            if (el.getText().equalsIgnoreCase("Water")) {
                el.click();
            }
            if (el.getText().equalsIgnoreCase("Wind")) {
                el.click();
            }
        }

        //7.Select radio - Selen
        List<WebElement> radioMenuItems = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("label-radio")));
        for (WebElement el : radioMenuItems) {
            if (el.getText().equalsIgnoreCase("Selen")) {
                el.click();
            }
        }

        //8.Select in dropdown - Yellow
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .elementToBeClickable(By.xpath("//option[text()=\"Yellow\"]")))
                                                       .click();

        //9.Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value
        List<WebElement> webpageLogItems = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector("[class=\"panel-body-list logs\"] > li")));
        String[] actualLogItemsTexts = webpageLogItems.stream().map(WebElement::getText).toArray(String[]::new);
        String[] expectedPartialLogItemsTexts =
            {"Colors: value changed to Yellow", "metal: value changed to  Selen", "Wind: condition changed to true",
                "Water: condition changed to true"};

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLogItemsTexts, expectedPartialLogItemsTexts);
    }
}
