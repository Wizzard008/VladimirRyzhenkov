package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class SubFunctionDataProvider {
    @DataProvider(name = Tags.SUB_DATA_PROVIDER_NAME)
    public Object[][] dpMethod() {
        return new Object[][] {{0, 0, 0}, {1, -1, 2}, {1, 1, 0}};
    }
}
