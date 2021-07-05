package ru.training.at.hw5.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw5.util.UserItem;

public class ThenStep extends AbstractStep {

    @DataTableType
    public UserItem itemEntry(Map<String, String> entry) {
        return new UserItem(
            entry.get("Number"),
            entry.get("User"),
            entry.get("Description"));
    }

    @Then("Check that current user is {string}")
    public void checkUserCredentials(String expectedUsername) {
        String actualDisplayedUsername = gdiIndexWebPage.getUserCredentials();
        Assert.assertTrue(actualDisplayedUsername.equalsIgnoreCase(expectedUsername));
    }

    @Then("For each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public void checkMessagesLogCheckboxesTexts() {
        String[] actualLogItemsTexts = differentElementsWebPage.getEventLogItemsTexts();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(
            actualLogItemsTexts[actualLogItemsTexts.length - 1].contains("Water: condition changed to true"));
        softAssert.assertTrue(
            actualLogItemsTexts[actualLogItemsTexts.length - 2].contains("Wind: condition changed to true"));
        softAssert.assertAll();
    }

    @Then("For radio button there is a log row and value is corresponded to the status of radio button")
    public void checkMessagesLogRadioTexts() {
        String[] actualLogItemsTexts = differentElementsWebPage.getEventLogItemsTexts();
        Assert
            .assertTrue(actualLogItemsTexts[actualLogItemsTexts.length - 3].contains("metal: value changed to Selen"));
    }

    @Then("For dropdown there is a log row and value is corresponded to the selected value")
    public void checkMessagesLogColorTexts() {
        String[] actualLogItemsTexts = differentElementsWebPage.getEventLogItemsTexts();
        Assert.assertTrue(actualLogItemsTexts[0].contains("Colors: value changed to Yellow"));
    }

    @Then("1 log row has {string} text in log section")
    public void checkMessagesLogColorTexts(String expectedText) {
        String actualLogItemText = userTableWebPage.getUserTablePageLogItemText();
        Assert.assertTrue(actualLogItemText.contains(expectedText));
    }

    @Then("{string} page should be opened")
    public void checkUserTablePAgeOpened(String expectedWebPageTitle) {
        String actualWebPageTitle = userTableWebPage.getPageTitle();
        Assert.assertEquals(actualWebPageTitle, expectedWebPageTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkAmountOfNumberTypes(int expectedAmountOfNumberTypes) {
        int actualAmountOfNumberTypes = userTableWebPage.getAmountOfNumberTypes();
        Assert.assertEquals(actualAmountOfNumberTypes, expectedAmountOfNumberTypes);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkAmountOfUserNames(int expectedAmountOfUserNames) {
        int actualAmountOfNumberTypes = userTableWebPage.getAmountOfUserNames();
        Assert.assertEquals(actualAmountOfNumberTypes, expectedAmountOfUserNames);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkAmountOfDescriptionTexts(int expectedAmountOfDescriptionTexts) {
        int actualAmountOfDescriptionTexts = userTableWebPage.getAmountOfDescriptionTexts();
        Assert.assertEquals(actualAmountOfDescriptionTexts, expectedAmountOfDescriptionTexts);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkAmountOfCheckboxes(int expectedAmountOfCheckboxes) {
        int actualAmountOfCheckboxes = userTableWebPage.getAmountOfCheckboxes();
        Assert.assertEquals(actualAmountOfCheckboxes, expectedAmountOfCheckboxes);
    }

    @Then("User table should contain following values:")
    public void verifyUserTableItems(List<UserItem> expectedUserItems) {
        List<UserItem> actualUserItems = userTableWebPage.getListOfItems();
        Assert.assertEquals(actualUserItems, expectedUserItems);
    }

    @Then("Droplist should contain values in column Type for user Roman")
    public void verifyDropDownItems(List<String> expectedDropdownItems) {
        List<String> actualDropDownItems = userTableWebPage.getDropdownValuesTexts();
        Assert.assertEquals(actualDropDownItems, expectedDropdownItems);
    }
}
