package ru.training.at.hw4.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.util.BaseSeleniumTest;

@Feature("Exercise 1 Web Page Fail Test")
@Story("Test basic functionality")
public class FailedEpamDemoWebPageTests extends BaseSeleniumTest {

    @Test(dataProvider = "DataProviderForExercise1", dataProviderClass = WebPageTestDataProviderEx1.class)
    public void exercise1WebPageTests(String expectedTitle, int expectedAmountOfPresentImages,
                                      String[] expectedHeaderMenuTitles, String[] expectedIconsTexts,
                                      String[] expectedMenuItemsTexts) {

        //1.Open test site by URL
        actionStep.openEpamWebPage();

        //2. Assert Browser title
        assertionStep.checkBrowserTitle(expectedTitle);

        //3.Perform login
        actionStep.userLogin(userLogin, userPassword);

        //4. Assert Username is loggined
        //        assertionStep.checkUserCredentials(expectedUsername);
        assertionStep.checkUserCredentials("Initial Fail Of The Test");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.checkItemsOnTheHeaderSection(expectedHeaderMenuTitles);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.checkAmountOfImagesOnTheIndexPage(expectedAmountOfPresentImages);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.checkIconsText(expectedIconsTexts);

        //8.Assert that there is the iframe
        assertionStep.checkPresenceOfIframe();

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIframe();
        assertionStep.checkPresenceOfFrameButton();

        //10.Switch to original window back
        actionStep.switchToOrigin();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.checkItemsInTheLeftSection(expectedMenuItemsTexts);
    }
}
