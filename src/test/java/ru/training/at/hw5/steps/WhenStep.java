package ru.training.at.hw5.steps;

import io.cucumber.java.en.When;

public class WhenStep extends AbstractStep {

    @When("I select checkboxes {string} and {string}")
    public void selectCheckbox(String checkboxItemToBeSelected1, String checkboxItemToBeSelected2) {
        differentElementsWebPage.selectCheckboxItem(checkboxItemToBeSelected1);
        differentElementsWebPage.selectCheckboxItem(checkboxItemToBeSelected2);
    }

    @When("I select radio {string}")
    public void selectRadioButton(String radioButtonToBeSelected) {
        differentElementsWebPage.selectRadioButton(radioButtonToBeSelected);
    }

    @When("I select in dropdown menu {string} color")
    public void selectColor(String colorToBeSelected) {
        differentElementsWebPage.selectColor(colorToBeSelected);
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectColor() {
        userTableWebPage.selectVipForSergeyIvanCheckboxItem();
    }
}
