package ru.training.at.hw3.ex2;

import org.testng.annotations.DataProvider;

public class WebPageTestDataProviderEx2 {

    @DataProvider(name = "DataProviderForExercise1Test1")
    public Object[][] testDataSetForWebPAgeTitleVerificationTest() {
        return new Object[][] {
            {"Home Page"}
        };
    }

    @DataProvider(name = "DataProviderForExercise1Test2")
    public Object[][] testDataSetForUserCredentialTest() {
        return new Object[][] {
            {"ROMAN IOVLEV"}
        };
    }

    private static final String[] EVENT_LOG_ITEMS =
        {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
            "Water: condition changed to true"};

    @DataProvider(name = "DataProviderForExercise1Test3")
    public Object[][] testDataSetForEventLogTest() {
        return new Object[][] {
            {"Water", "Wind", "Selen", "Yellow", EVENT_LOG_ITEMS}
        };
    }
}
