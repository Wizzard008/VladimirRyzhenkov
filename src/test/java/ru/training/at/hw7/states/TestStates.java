package ru.training.at.hw7.states;

import static ru.training.at.hw7.JdiWebSite.indexWebPage;
import static ru.training.at.hw7.pages.IndexWebPage.headerMenu;
import static ru.training.at.hw7.pages.IndexWebPage.loginForm;
import static ru.training.at.hw7.pages.IndexWebPage.userIcon;
import static ru.training.at.hw7.pages.IndexWebPage.userName;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.colors;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.elements;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.evenNumbers;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.getActualResult;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.metals;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.oddNumbers;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.submitButton;
import static ru.training.at.hw7.pages.MetalsAndColorsWebPage.vegetables;

import io.qameta.allure.Step;
import java.util.Arrays;
import org.testng.Assert;
import ru.training.at.hw7.entities.User;

public class TestStates {

    public static void openIndexPage() {
        indexWebPage.open();
    }

    @Step
    public static void loginOnJdiWebSite() {
        openIndexPage();
        if (!userName.isDisplayed()) {
            userIcon.click();
            loginForm.submit(new User(), "enter");
        }
    }

    @Step
    public static void openMetalsAndColorsWebPage() {
        headerMenu.select("Metals & Colors");
    }

    @Step
    public static void selectRadioButtons(int[] radioButtonsToSelect) {
        for (int radioButtonNumber : radioButtonsToSelect) {
            if (radioButtonNumber % 2 == 0) {
                evenNumbers.select(String.valueOf(radioButtonNumber));
            } else {
                oddNumbers.select(String.valueOf(radioButtonNumber));
            }
        }
    }

    @Step
    public static void selectColorInDropdownMenu(String colorName) {
        colors.select(colorName);
    }

    @Step
    public static void selectMetalsInDropdownMenu(String metalName) {
        metals.select(metalName);
    }

    @Step
    public static void checkVegetablesInDropdownMenu(String[] vegetablesToSelect) {
        Arrays.stream(vegetablesToSelect).forEach(e -> vegetables.select(e));
    }

    @Step
    public static void uncheckVegetable(String vegetableName) {
        vegetables.select(vegetableName);
    }

    @Step
    public static void selectCheckboxesForElements(String[] elementsToSelect) {
        Arrays.stream(elementsToSelect).forEach(e -> elements.select(e));
    }

    @Step
    public static void submitMetalsAndColorsForm() {
        submitButton.click();
    }

    @Step
    public static void assertCorrectSummaryValuesRepresentationInLog(String expectedResult) {
        Assert.assertEquals(getActualResult(), expectedResult);
    }
}
