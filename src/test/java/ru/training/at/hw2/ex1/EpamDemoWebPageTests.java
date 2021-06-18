package ru.training.at.hw2.ex1;

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

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenuButtons = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By.xpath("//div[1]/nav[1]/ul[1]/li/a")));

        Assert.assertEquals(headerMenuButtons.size(), 4);
        Assert.assertEquals(headerMenuButtons.get(0).getText(), "HOME");
        Assert.assertEquals(headerMenuButtons.get(1).getText(), "CONTACT FORM");
        Assert.assertEquals(headerMenuButtons.get(2).getText(), "SERVICE");
        Assert.assertEquals(headerMenuButtons.get(3).getText(), "METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconsImages = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,\"icon\")]")));

        int actualAmountOfPresentImages = iconsImages.size();
        int expectedAmountOfPresentImages = 4;
        Assert.assertEquals(actualAmountOfPresentImages, expectedAmountOfPresentImages);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconsTextsWebElements =
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class,\"benefit-txt\")]")));

        String expectedFirstBoxText = "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project";
        String expectedSecondBoxText = "To be flexible and\n"
            + "customizable";
        String expectedThirdBoxText = "To be multiplatform";
        String expectedForthBoxText = "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…";

        Assert.assertTrue(iconsTextsWebElements.get(0).getText().equalsIgnoreCase(expectedFirstBoxText));
        Assert.assertTrue(iconsTextsWebElements.get(1).getText().equalsIgnoreCase(expectedSecondBoxText));
        Assert.assertTrue(iconsTextsWebElements.get(2).getText().equalsIgnoreCase(expectedThirdBoxText));
        Assert.assertTrue(iconsTextsWebElements.get(3).getText().equalsIgnoreCase(expectedForthBoxText));

        //8.Assert that there is the iframe with “Frame Button” exist
        Assert.assertTrue(driver.getPageSource().contains("iframe"));

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        WebElement iframe = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .presenceOfElementLocated(By.id("frame")));

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
            .frameToBeAvailableAndSwitchToIt(iframe));

        Assert.assertTrue(driver.getPageSource().contains("frame-button"));

        //10.Switch to original window back
        driver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionMenuWebElements =
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//ul[@class=\"sidebar-menu left\"]/li/a/span")));
        String expectedMenuItem1 = "Home";
        String expectedMenuItem2 = "Contact form";
        String expectedMenuItem3 = "Service";
        String expectedMenuItem4 = "Metals & Colors";
        String expectedMenuItem5 = "Elements packs";
        Assert.assertEquals(leftSectionMenuWebElements.get(0).getText(), expectedMenuItem1);
        Assert.assertEquals(leftSectionMenuWebElements.get(1).getText(), expectedMenuItem2);
        Assert.assertEquals(leftSectionMenuWebElements.get(2).getText(), expectedMenuItem3);
        Assert.assertEquals(leftSectionMenuWebElements.get(3).getText(), expectedMenuItem4);
        Assert.assertEquals(leftSectionMenuWebElements.get(4).getText(), expectedMenuItem5);
    }
}
