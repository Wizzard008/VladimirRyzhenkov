package ru.training.at.hw3.ex2;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.page.FluentWebPageObjectForEx2;
import ru.training.at.hw3.util.WebPageTestsCommonConditions;

public class EpamDemoWebPageTests extends WebPageTestsCommonConditions {
    private FluentWebPageObjectForEx2 webPageObject;



    @Test(dataProvider = "DataProviderForExercise1Test1", dataProviderClass = WebPageTestDataProviderEx2.class)
    public void verificationWebPageTitle(String expectedWebPageTitle) {
        webPageObject = new FluentWebPageObjectForEx2(driver);
        String actualWebPageTitle = webPageObject.openWebPage().getWebPageTitle();
        Assert.assertEquals(actualWebPageTitle, expectedWebPageTitle);
    }

    @Test(dataProvider = "DataProviderForExercise1Test2", dataProviderClass = WebPageTestDataProviderEx2.class)
    public void verificationOfUserCredentials(String expectedUserCredentials) {
        webPageObject = new FluentWebPageObjectForEx2(driver);
        String actualUserCredentials = webPageObject.openWebPage().login(userLogin, userPassword).getUserCredentials();
        Assert.assertEquals(actualUserCredentials, expectedUserCredentials);
    }

    @Test(dataProvider = "DataProviderForExercise1Test3", dataProviderClass = WebPageTestDataProviderEx2.class)
    public void verificationOfWebPageEventLog(String checkboxItemToBeSelected1,
                                              String checkboxItemToBeSelected2, String radioButtonToBeSelected,
                                              String colorToBeSelected,
                                              String[]expectedPartialLogItemsTexts) {
        webPageObject = new FluentWebPageObjectForEx2(driver);
        String[] actualLogItemsTexts = webPageObject.openWebPage()
                                                    .login(userLogin, userPassword)
                                                    .openDifferentElementsWebPage()
                                                    .selectCheckbox(checkboxItemToBeSelected1)
                                                    .selectCheckbox(checkboxItemToBeSelected2)
                                                    .selectSelenRadioButton(radioButtonToBeSelected)
                                                    .selectColor(colorToBeSelected)
                                                    .getMessagesLogItemsTexts();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualLogItemsTexts, expectedPartialLogItemsTexts);
    }
}
