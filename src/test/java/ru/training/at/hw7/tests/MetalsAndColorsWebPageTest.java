package ru.training.at.hw7.tests;

import static ru.training.at.hw7.states.TestStates.assertCorrectSummaryValuesRepresentationInLog;
import static ru.training.at.hw7.states.TestStates.checkVegetablesInDropdownMenu;
import static ru.training.at.hw7.states.TestStates.loginOnJdiWebSite;
import static ru.training.at.hw7.states.TestStates.openMetalsAndColorsWebPage;
import static ru.training.at.hw7.states.TestStates.selectCheckboxesForElements;
import static ru.training.at.hw7.states.TestStates.selectColorInDropdownMenu;
import static ru.training.at.hw7.states.TestStates.selectMetalsInDropdownMenu;
import static ru.training.at.hw7.states.TestStates.selectRadioButtons;
import static ru.training.at.hw7.states.TestStates.submitMetalsAndColorsForm;
import static ru.training.at.hw7.states.TestStates.uncheckVegetable;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw7.TestsInit;
import ru.training.at.hw7.entities.TestData;

@Feature("JDI Metals&Colors Web Page Tests")
@Story("User can submit data to Metals & Colors form and receive proper Log information")

public class MetalsAndColorsWebPageTest implements TestsInit {

    @Test(dataProvider = "TestDataProvider", dataProviderClass = TestDataProvider.class)
    public void metalsAndColorsWebPageTests(TestData testData) {

        //1.Login on JDI site as User
        loginOnJdiWebSite();

        //2. Open Metals & Colors page by Header menu
        openMetalsAndColorsWebPage();

        //3.Fill form Metals & Colors
        selectRadioButtons(testData.getSummary());

        //3.Select color
        selectColorInDropdownMenu(testData.getColor());

        //3.Select metal
        selectMetalsInDropdownMenu(testData.getMetals());

        //3.Select veg
        uncheckVegetable("Vegetables");
        checkVegetablesInDropdownMenu(testData.getVegetables());

        //4.Select elements
        selectCheckboxesForElements(testData.getElements());

        //5.Submit
        submitMetalsAndColorsForm();

        //6.Assertion
        assertCorrectSummaryValuesRepresentationInLog(testData.getExpectedResult());
    }
}
