package ru.training.at.hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import ru.training.at.hw7.entities.User;

@Url("/index.html")
@Title("Home Page")
public class IndexWebPage extends WebPage {

    @Css("form")
    public static Form<User> loginForm;
    @Css(".profile-photo [ui=label]")
    public static UIElement userName;
    @Css("img#user-icon")
    public static UIElement userIcon;
    @UI(".uui-navigation.nav.navbar-nav.m-l8 > li")
    public static Menu headerMenu;
}
