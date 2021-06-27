package ru.training.at.hw3.ex2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.page.VoidWebPageObject;
import ru.training.at.hw3.util.WebPageTestsCommonConditions;

public class EpamDemoWebPageTests extends WebPageTestsCommonConditions {

    @Test(dataProvider = "DataProviderForExercise2", dataProviderClass = WebPageTestDataProviderEx2.class)
    public void verificationOfWebPageEventLog(String expectedWebPageTitle, String expectedUserCredentials,
                                              String checkboxItemToBeSelected1,
                                              String checkboxItemToBeSelected2, String radioButtonToBeSelected,
                                              String colorToBeSelected,
                                              String[] expectedPartialLogItemsTexts) {
        VoidWebPageObject webPageObject = new VoidWebPageObject(driver);
        //1.Open test site by URL
        webPageObject.openWebPage();
        //2. Assert Browser title
        String actualWebPageTitle = webPageObject.getWebPageTitle();
        Assert.assertEquals(actualWebPageTitle, expectedWebPageTitle);
        //3.Perform login
        webPageObject.login(userLogin, userPassword);
        //4. Assert Username is loggined
        String actualUserCredentials = webPageObject.getUserCredentials();
        Assert.assertEquals(actualUserCredentials, expectedUserCredentials);
        //5.Open through the header menu Service -> Different Elements Page
        webPageObject.openDifferentElementsWebPage();
        //6.Select checkboxes - Water, Wind
        webPageObject.selectCheckbox(checkboxItemToBeSelected1);
        webPageObject.selectCheckbox(checkboxItemToBeSelected2);
        //7.Select radio - Selen
        webPageObject.selectSelenRadioButton(radioButtonToBeSelected);
        //8.Select in dropdown - Yellow
        webPageObject.selectColor(colorToBeSelected);
        //9.Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value
        String[] actualLogItemsTexts = webPageObject.getMessagesLogItemsTexts();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLogItemsTexts, expectedPartialLogItemsTexts);
    }
}
