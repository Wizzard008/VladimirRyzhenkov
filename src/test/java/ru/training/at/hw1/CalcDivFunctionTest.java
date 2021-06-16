package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDivFunctionTest extends CalculatorTestsCommonConditions {

    @Test(groups = {Tags.MULT_DIV_OPERATIONS}, dataProvider = Tags.DIV_DATA_PROVIDER_NAME,
          dataProviderClass = DivFunctionDataProvider.class)
    public void divideTest(double firstArgument, double secondArgument, double expectedResult) {
        double actualResult = calculator.div(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult, ACCURACY);
    }
}
