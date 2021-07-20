package ru.training.at.hw7.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import java.util.List;
import org.openqa.selenium.WebElement;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsWebPage extends WebPage {

    @UI("[name=custom_radio_odd]")
    public static RadioButtons oddNumbers;

    @UI("[name=custom_radio_even]")
    public static RadioButtons evenNumbers;

    @JDropdown(root = "div[ui=dropdown]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "div[ui=combobox]", value = ".filter-option", list = "li", expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "#salad-dropdown", value = "#salad-dropdown > button", list = "li", expand = ".caret")
    public static Dropdown vegetables;

    @UI("[type='checkbox']")
    public static Checklist elements;

    @UI("[id='submit-button']")
    public static Button submitButton;

    @UI("[class='panel-body-list results'] > li")
    public static List<WebElement> summaryTexts;

    public static String getActualResult() {
        return summaryTexts.stream().map(WebElement::getText).reduce((s1, s2) -> s1 + "; " + s2).get();
    }
}
