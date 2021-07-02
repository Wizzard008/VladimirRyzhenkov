package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert Browser title")
    public void checkBrowserTitle(String expectedTitle) {
        String actualTitle = webPageObject.getWebPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Step("Assert Username is loggined")
    public void checkUserCredentials(String expectedUsername) {
        String actualDisplayedUsername = webPageObject.getUserCredentials();
        Assert.assertEquals(actualDisplayedUsername, expectedUsername);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void checkItemsOnTheHeaderSection(String[] expectedHeaderMenuTitles) {
        String[] actualHeaderMenuTitles = webPageObject.getHeaderMenuTexts();
        Assert.assertEquals(actualHeaderMenuTitles, expectedHeaderMenuTitles);
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void checkAmountOfImagesOnTheIndexPage(int expectedAmountOfPresentImages) {
        int actualAmountOfPresentImages = webPageObject.getAmountOfImages();
        Assert.assertEquals(actualAmountOfPresentImages, expectedAmountOfPresentImages);
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkIconsText(String[] expectedIconsTexts) {
        String[] actualIconsTexts = webPageObject.getIconsTexts();
        Assert.assertEquals(actualIconsTexts, expectedIconsTexts);
    }

    @Step("Assert that there is the iframe")
    public void checkPresenceOfIframe() {
        try {
            Assert.assertTrue(webPageObject.getIframe().isDisplayed());
        } catch (NullPointerException e) {
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Check that there is “Frame Button” in the iframe")
    public void checkPresenceOfFrameButton() {
        try {
            Assert.assertTrue(webPageObject.getFrameButton().isDisplayed());
        } catch (NullPointerException e) {
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void checkItemsInTheLeftSection(String[] expectedMenuItemsTexts) {
        String[] actualMenuItemsTexts = webPageObject.getLeftSectionMenuTexts();
        Assert.assertEquals(actualMenuItemsTexts, expectedMenuItemsTexts);
    }

    @Step("Assert that\n"
              + "        • for each checkbox there is an individual log row and "
              + "value is corresponded to the status of checkbox\n"
              + "        • for radio button there is a log row and "
              + "value is corresponded to the status of radio button\n"
              + "        • for dropdown there is a log row and "
              + "value is corresponded to the selected value")
    public void checkMessagesLogItemsTexts(String[] expectedPartialLogItemsTexts) {
        String[] actualLogItemsTexts = webPageObject.getMessagesLogItemsTexts();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEqualsNoOrder(actualLogItemsTexts, expectedPartialLogItemsTexts);
    }
}
