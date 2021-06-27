package ru.training.at.hw3.page;


import org.openqa.selenium.WebDriver;

public class VoidWebPageObject extends AbstractPage {

    public VoidWebPageObject(WebDriver driver) {
        super(driver);
    }

    public void openWebPage() {
        driver.get(HOMEPAGE_URL);
    }

    public String getWebPageTitle() {
        return driver.getTitle();
    }

    public void login(String userLogin, String userPassword) {
        headerMenu.login(userLogin, userPassword);
    }

    public String getUserCredentials() {
        return headerMenu.getUserCredentials();
    }

    public String[] getHeaderMenuTexts() {
        return headerMenu.getMenuTexts();
    }

    public int getAmountOfImages() {
        return icons.getAmountOfImages();
    }

    public String[] getIconsTexts() {
        return icons.getIconsTexts();
    }

    public boolean verifyPresenceOfIframe() {
        return frame.frameIsAvailable();
    }

    public boolean verifyPresenceOfButtonOnIframe() {
        return frame.frameButtonIsAvailable();
    }

    public void switchToFrame() {
        frame.switchToFrame();
    }

    public void switchToOrigin() {
        driver.switchTo().defaultContent();
    }

    public String[] getLeftSectionMenuTexts() {
        return leftSideMenu.getLeftSectionMenuTexts();
    }

    public void openDifferentElementsWebPage() {
        headerMenu.openDifferentElementsWebPage();
    }

    public void selectCheckbox(String checkboxItemToBeSelected) {
        checkbox.selectCheckboxItem(checkboxItemToBeSelected);
    }

    public void selectSelenRadioButton(String radioButtonToBeSelected) {
        radioButton.selectRadioButton(radioButtonToBeSelected);
    }

    public void selectColor(String colorToBeSelected) {
        colorSelector.selectColor(colorToBeSelected);
    }

    public String[] getMessagesLogItemsTexts() {
        return eventLog.getEventLogItemsTexts();
    }


}
