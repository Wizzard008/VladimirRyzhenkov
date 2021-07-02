package ru.training.at.hw4.steps;


import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.page.EpamWebPageObject;

public abstract class AbstractStep {

    protected EpamWebPageObject webPageObject;

    protected AbstractStep(WebDriver driver) {
        webPageObject = new EpamWebPageObject(driver);
    }

}
