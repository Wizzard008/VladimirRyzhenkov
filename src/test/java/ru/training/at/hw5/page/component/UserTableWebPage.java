package ru.training.at.hw5.page.component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.util.UserItem;

public class UserTableWebPage extends AbstractPage {

    @FindBy(id = "ivan")
    WebElement checkboxIvan;

    @FindBy(css = "div.info-panel-section > ul > li")
    WebElement webpageLogItem;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(1)")
    List<WebElement> numberTypeItems;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(3)")
    List<WebElement> userNamesItems;

    @FindBy(css = ".user-descr > span")
    List<WebElement> descriptionsTexts;

    @FindBy(css = "[type=checkbox]")
    List<WebElement> checkboxes;

    @FindBy(css = "tr:nth-child(1) > td > select > option")
    List<WebElement> romansDropdownMenuItems;

    public UserTableWebPage(WebDriver driver) {
        super(driver);
    }

    public void selectVipForSergeyIvanCheckboxItem() {
        checkboxIvan.click();
    }

    public String getUserTablePageLogItemText() {
        return webpageLogItem.getText();
    }

    public int getAmountOfNumberTypes() {
        return numberTypeItems.size();
    }

    public int getAmountOfUserNames() {
        return userNamesItems.size();
    }

    public int getAmountOfDescriptionTexts() {
        return descriptionsTexts.size();
    }

    public int getAmountOfCheckboxes() {
        return checkboxes.size();
    }

    public List<String> getNumbersTexts() {
        return numberTypeItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getUserTexts() {
        return userNamesItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getDescriptionTexts() {
        return descriptionsTexts.stream().map(e -> e.getText().replaceAll("\n", " "))
                                .collect(Collectors.toList());
    }

    public List<String> getDropdownValuesTexts() {
        return romansDropdownMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<UserItem> getListOfItems() {
        List<UserItem> listOfUserItems = new ArrayList<>();
        List<String> listOfNumbers = getNumbersTexts();
        List<String> listOfUsers = getUserTexts();
        List<String> listOfDescriptions = getDescriptionTexts();
        for (int i = 0; i < listOfNumbers.size(); i++) {
            listOfUserItems.add(new UserItem(listOfNumbers.get(i), listOfUsers.get(i), listOfDescriptions.get(i)));
        }
        return listOfUserItems;
    }
}
