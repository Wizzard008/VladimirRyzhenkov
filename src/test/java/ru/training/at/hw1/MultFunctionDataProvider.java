package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class MultFunctionDataProvider {
    @DataProvider(name = Tags.MULT_DATA_PROVIDER_NAME)
    public Object[][] dpMethod() {
        return new Object[][] {{0, 0, 0}, {1, -1, -1}, {1, 1, 1}};
    }
}
