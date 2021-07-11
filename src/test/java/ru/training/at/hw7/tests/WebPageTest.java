package ru.training.at.hw7.tests;

import static ru.training.at.hw7.states.TestStates.assertion;
import static ru.training.at.hw7.states.TestStates.checkVegetable;
import static ru.training.at.hw7.states.TestStates.login;
import static ru.training.at.hw7.states.TestStates.openMetalsAndColorsWebPage;
import static ru.training.at.hw7.states.TestStates.selectColor;
import static ru.training.at.hw7.states.TestStates.selectElement;
import static ru.training.at.hw7.states.TestStates.selectMetal;
import static ru.training.at.hw7.states.TestStates.selectRadioButtons;
import static ru.training.at.hw7.states.TestStates.submit;
import static ru.training.at.hw7.states.TestStates.uncheckVegetable;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw7.TestsInit;
import ru.training.at.hw7.entities.TestData;

@Feature("JDI Web Page Tests")
@Story("User can submit data to Metals & Colors form")

public class WebPageTest implements TestsInit {

    @Test(dataProvider = "TestDataProvider", dataProviderClass = TestDataProvider.class)
    public void webPageTests(TestData testData) {

        //1.Login on JDI site as User
        login();

        //2. Open Metals & Colors page by Header menu
        openMetalsAndColorsWebPage();

        //3.Fill form Metals & Colors
        selectRadioButtons(testData.getSummary());

        //3.Select color
        selectColor(testData.getColor());

        //3.Select metal
        selectMetal(testData.getMetals());

        //3.Select veg
        uncheckVegetable("Vegetables");
        checkVegetable(testData.getVegetables());

        //4.Select elements
        selectElement(testData.getElements());

        //5.Submit
        submit();

        //6.Assertion
        assertion(testData.getExpectedResult());
    }
}
