package ru.training.at.hw6.ex1;

import org.testng.annotations.DataProvider;

public class WebPageTestDataProviderEx1 {

    private static final String[] HEADER_MENU_TITLES = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    private static final String[] INDEX_PAGE_ICONS_TEXTS =
        {"To include good practices\nand ideas from successful\nEPAM project", "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
    private static final String[] LEFT_SECTION_MENU_TITLES =
        {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

    @DataProvider(name = "DataProviderForExercise1")
    public Object[][] testDataSet() {
        return new Object[][] {
            {"Home Page", 4, HEADER_MENU_TITLES, INDEX_PAGE_ICONS_TEXTS, LEFT_SECTION_MENU_TITLES}
        };
    }
}
