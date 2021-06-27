package ru.training.at.hw3.page;

import org.openqa.selenium.WebDriver;

public class FluentWebPageObjectForEx2 extends AbstractPage {

    public FluentWebPageObjectForEx2(WebDriver driver) {
        super(driver);
    }

    public FluentWebPageObjectForEx2 openWebPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String getWebPageTitle() {
        return driver.getTitle();
    }

    public FluentWebPageObjectForEx2 login(String userLogin, String userPassword) {
        headerMenu.login(userLogin, userPassword);
        return this;
    }

    public String getUserCredentials() {
        return headerMenu.getUserCredentials();
    }

    public FluentWebPageObjectForEx2 openDifferentElementsWebPage() {
        headerMenu.openDifferentElementsWebPage();
        return this;
    }

    public FluentWebPageObjectForEx2 selectCheckbox(String checkboxItemToBeSelected) {
        checkbox.selectCheckboxItem(checkboxItemToBeSelected);
        return this;
    }

    public FluentWebPageObjectForEx2 selectSelenRadioButton(String radioButtonToBeSelected) {
        radioButton.selectRadioButton(radioButtonToBeSelected);
        return this;
    }

    public FluentWebPageObjectForEx2 selectColor(String colorToBeSelected) {
        colorSelector.selectColor(colorToBeSelected);
        return this;
    }

    public String[] getMessagesLogItemsTexts() {
        return eventLog.getEventLogItemsTexts();
    }
}
