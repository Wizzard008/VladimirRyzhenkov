package ru.training.at.hw1;

import org.testng.annotations.DataProvider;

public class DivFunctionDataProvider {
    @DataProvider(name = Tags.DIV_DATA_PROVIDER_NAME)
    public Object[][] dpMethod() {
        return new Object[][] {{0, 1, 0}, {1, 1, 1}, {1, -1, -1}, {5, 5, 1}};
    }
}
