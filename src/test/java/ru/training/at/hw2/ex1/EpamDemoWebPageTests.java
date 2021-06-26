package ru.training.at.hw2.ex1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
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

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerMenuButtons = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector("[class=\"uui-navigation nav navbar-nav m-l8\"] > li")));
        String[] actualHeaderMenuTitles = headerMenuButtons.stream().map(WebElement::getText).toArray(String[]::new);
        String[] expectedHeaderMenuTitles = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        Assert.assertEquals(actualHeaderMenuTitles, expectedHeaderMenuTitles);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> iconsImages = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".benefit-icon")));

        int actualAmountOfPresentImages = iconsImages.size();
        int expectedAmountOfPresentImages = 4;
        Assert.assertEquals(actualAmountOfPresentImages, expectedAmountOfPresentImages);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconsTextsWebElements = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions
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

        String[] actualIconsTexts = iconsTextsWebElements.stream().map(WebElement::getText).toArray(String[]::new);
        String[] expectedIconsTexts =
            {expectedFirstBoxText, expectedSecondBoxText, expectedThirdBoxText, expectedForthBoxText};
        Assert.assertEquals(actualIconsTexts, expectedIconsTexts);

        //8.Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("frame")));
        Assert.assertTrue(iframe.isDisplayed());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(iframe);

        WebElement frameButtonWebElement = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(By.id("frame-button")));

        Assert.assertTrue(frameButtonWebElement.isDisplayed());

        //10.Switch to original window back
        driver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionMenuWebElements =
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By.cssSelector("#mCSB_1_container > ul > li > a > span")));

        String[] actualMenuItemsTexts =
            leftSectionMenuWebElements.stream().map(WebElement::getText).toArray(String[]::new);
        String[] expectedMenuItemsTexts = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        Assert.assertEquals(actualMenuItemsTexts, expectedMenuItemsTexts);
    }
}
