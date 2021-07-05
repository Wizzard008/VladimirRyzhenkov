package ru.training.at.hw5.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GdiIndexWebPage extends AbstractPage {

    @FindBy(className = "profile-photo")
    WebElement userProfileButton;

    @FindBy(id = "name")
    WebElement userLoginField;

    @FindBy(id = "password")
    WebElement userPasswordField;

    @FindBy(id = "login-button")
    WebElement userLoginButton;

    @FindBy(id = "user-name")
    WebElement userCredentials;

    @FindBy(css = ".dropdown-toggle")
    WebElement serviceDropDownMenu;

    @FindBy(xpath = "//a[contains(@href,'different-elements.html')]")
    WebElement differentElementsPageLink;

    @FindBy(xpath = "//a[contains(@href,'user-table.html')]")
    WebElement userTablePageLink;

    public GdiIndexWebPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userLogin, String userPassword) {
        userProfileButton.click();
        userLoginField.sendKeys(userLogin);
        userPasswordField.sendKeys(userPassword);
        userLoginButton.click();
    }

    public String getUserCredentials() {
        return userCredentials.getText();
    }

    public void openDifferentElementsWebPage() {
        serviceDropDownMenu.click();
        differentElementsPageLink.click();
    }

    public void clickServiceButton() {
        serviceDropDownMenu.click();
    }

    public void openUserTableWebPage() {
        userTablePageLink.click();
    }
}
