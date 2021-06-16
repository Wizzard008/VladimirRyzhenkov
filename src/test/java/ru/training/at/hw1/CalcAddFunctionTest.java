package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcAddFunctionTest extends CalculatorTestsCommonConditions {

    @Test(groups = {Tags.ADD_SUB_OPERATIONS},
          dataProvider = Tags.SUM_DATA_PROVIDER_NAME,
          dataProviderClass = SumFunctionDataProvider.class)
    public void summationTest(double firstArgument, double secondArgument, double expectedResult) {
        double actualResult = calculator.sum(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult, ACCURACY);
    }
}
