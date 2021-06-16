package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSubFunctionTest extends CalculatorTestsCommonConditions {

    @Test(groups = {Tags.ADD_SUB_OPERATIONS},
          dataProvider = Tags.SUB_DATA_PROVIDER_NAME,
          dataProviderClass = SubFunctionDataProvider.class)
    public void subtractionTest(double firstArgument, double secondArgument, double expectedResult) {
        double actualResult = calculator.sub(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult, ACCURACY);
    }
}
