package ru.training.at.hw3.ex1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.page.VoidWebPageObjectForEx1;
import ru.training.at.hw3.util.WebPageTestsCommonConditions;

public class EpamDemoWebPageTests extends WebPageTestsCommonConditions {

    @Test(dataProvider = "DataProviderForExercise1", dataProviderClass = WebPageTestDataProviderEx1.class)
    public void demoPageTests(String expectedTitle, String expectedUsername, int expectedAmountOfPresentImages,
                              String[] expectedHeaderMenuTitles, String[] expectedIconsTexts,
                              String[] expectedMenuItemsTexts) {
        VoidWebPageObjectForEx1 webPageObject = new VoidWebPageObjectForEx1(driver);

        //1.Open test site by URL
        webPageObject.openWebPage();

        //2. Assert Browser title
        String actualTitle = webPageObject.getWebPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        //3.Perform login
        webPageObject.login(userLogin, userPassword);

        //4. Assert Username is loggined
        String actualDisplayedUsername = webPageObject.getUserCredentials();
        Assert.assertEquals(actualDisplayedUsername, expectedUsername);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        String[] actualHeaderMenuTitles = webPageObject.getHeaderMenuTexts();
        Assert.assertEquals(actualHeaderMenuTitles, expectedHeaderMenuTitles);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        int actualAmountOfPresentImages = webPageObject.getAmountOfImages();
        Assert.assertEquals(actualAmountOfPresentImages, expectedAmountOfPresentImages);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] actualIconsTexts = webPageObject.getIconsTexts();
        Assert.assertEquals(actualIconsTexts, expectedIconsTexts);

        //8.Assert that there is the iframe
        Assert.assertTrue(webPageObject.verifyPresenceOfIframe());

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        webPageObject.switchToFrame();
        Assert.assertTrue(webPageObject.verifyPresenceOfButtonOnIframe());

        //10.Switch to original window back
        webPageObject.switchToOrigin();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] actualMenuItemsTexts = webPageObject.getLeftSectionMenuTexts();
        Assert.assertEquals(actualMenuItemsTexts, expectedMenuItemsTexts);
    }
}
