package ru.training.at.hw6.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open test site by URL")
    public void openEpamWebPage() {
        webPageObject.openWebPage();
    }

    @Step("Perform login")
    public void userLogin(String userLogin, String userPassword) {
        webPageObject.login(userLogin, userPassword);
    }

    @Step("Switch to the iframe")
    public void switchToIframe() {
        webPageObject.getDriver().switchTo().frame(webPageObject.getIframe());
    }

    @Step("Switch to original window back")
    public void switchToOrigin() {
        webPageObject.switchToOrigin();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        webPageObject.openDifferentElementsWebPage();
    }

    @Step("Select checkbox")
    public void selectCheckbox(String checkboxItemToBeSelected) {
        webPageObject.selectCheckbox(checkboxItemToBeSelected);
    }

    @Step("Select radio")
    public void selectRadioButton(String radioButtonToBeSelected) {
        webPageObject.selectSelenRadioButton(radioButtonToBeSelected);
    }

    @Step("Select in dropdown")
    public void selectColor(String colorToBeSelected) {
        webPageObject.selectColor(colorToBeSelected);
    }
}
