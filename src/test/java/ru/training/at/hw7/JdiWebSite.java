package ru.training.at.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import ru.training.at.hw7.pages.IndexWebPage;
import ru.training.at.hw7.pages.MetalsAndColorsWebPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiWebSite {
    public static IndexWebPage indexWebPage;
    public static MetalsAndColorsWebPage metalsAndColorsWebPage;
}
