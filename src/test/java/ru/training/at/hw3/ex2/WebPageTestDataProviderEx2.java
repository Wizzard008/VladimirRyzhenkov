package ru.training.at.hw3.ex2;

import org.testng.annotations.DataProvider;

public class WebPageTestDataProviderEx2 {

    private static final String[] EVENT_LOG_ITEMS =
        {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
            "Water: condition changed to true"};

    @DataProvider(name = "DataProviderForExercise2")
    public Object[][] testDataSetForEventLogTest() {
        return new Object[][] {
            {"Home Page", "ROMAN IOVLEV", "Water", "Wind", "Selen", "Yellow", EVENT_LOG_ITEMS}
        };
    }
}
