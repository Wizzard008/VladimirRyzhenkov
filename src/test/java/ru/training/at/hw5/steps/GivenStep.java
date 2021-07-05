package ru.training.at.hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openEpamWebPage() {
        driver.get(HOMEPAGE_URL);
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void userLogin() {
        gdiIndexWebPage.login(resourceBundle.getString(USER_LOGIN_KEY), resourceBundle.getString(USER_PASSWORD_KEY));
    }

    @Given("I open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        gdiIndexWebPage.openDifferentElementsWebPage();
    }

    @Given("I click on \"Service\" button in Header")
    public void clickServiceButton() {
        gdiIndexWebPage.clickServiceButton();
    }

    @Given("I click on \"User Table\" button in Service dropdown")
    public void openUserTablePage() {
        gdiIndexWebPage.openUserTableWebPage();
    }
}
