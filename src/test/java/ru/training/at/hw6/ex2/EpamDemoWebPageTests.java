package ru.training.at.hw6.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw6.util.BaseSeleniumTest;

@Feature("Exercise 2 Web Page Tests")
@Story("Test basic functionality")
public class EpamDemoWebPageTests extends BaseSeleniumTest {

    @Test(dataProvider = "DataProviderForExercise2", dataProviderClass = WebPageTestDataProviderEx2.class)
    public void exercise2WebPageTests(String expectedWebPageTitle,
                                      String checkboxItemToBeSelected1,
                                      String checkboxItemToBeSelected2, String radioButtonToBeSelected,
                                      String colorToBeSelected,
                                      String[] expectedPartialLogItemsTexts) {
        //1.Open test site by URL
        actionStep.openEpamWebPage();

        //2. Assert Browser title
        assertionStep.checkBrowserTitle(expectedWebPageTitle);

        //3.Perform login
        actionStep.userLogin(userLogin, userPassword);

        //4. Assert Username is loggined
        assertionStep.checkUserCredentials(expectedUsername);

        //5.Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6.Select checkboxes - Water, Wind
        actionStep.selectCheckbox(checkboxItemToBeSelected1);
        actionStep.selectCheckbox(checkboxItemToBeSelected2);

        //7.Select radio - Selen
        actionStep.selectRadioButton(radioButtonToBeSelected);

        //8.Select in dropdown - Yellow
        actionStep.selectColor(colorToBeSelected);

        //9.Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value
        assertionStep.checkMessagesLogItemsTexts(expectedPartialLogItemsTexts);
    }
}
