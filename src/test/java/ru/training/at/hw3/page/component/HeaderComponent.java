package ru.training.at.hw3.page.component;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

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

    @FindBy(css = "[class=\"uui-navigation nav navbar-nav m-l8\"] > li")
    List<WebElement> headerMenuButtons;

    @FindBy(css = ".dropdown-toggle")
    WebElement serviceDropDownMenu;

    @FindBy(xpath = "//a[contains(@href,\"different-elements.html\")]")
    WebElement differentElementsPageLink;

    public HeaderComponent(WebDriver driver) {
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

    public String[] getMenuTexts() {
        return headerMenuButtons.stream().map(WebElement::getText).toArray(String[]::new);
    }

    public void openDifferentElementsWebPage() {
        serviceDropDownMenu.click();
        differentElementsPageLink.click();
    }
}
