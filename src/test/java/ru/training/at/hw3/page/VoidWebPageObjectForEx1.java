package ru.training.at.hw3.page;

import org.openqa.selenium.WebDriver;

public class VoidWebPageObjectForEx1 extends AbstractPage {

    public VoidWebPageObjectForEx1(WebDriver driver) {
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
}
