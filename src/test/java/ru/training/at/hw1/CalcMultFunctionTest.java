package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcMultFunctionTest extends CalculatorTestsCommonConditions {

    @Test(groups = {Tags.MULT_DIV_OPERATIONS},
          dataProvider = Tags.MULT_DATA_PROVIDER_NAME,
          dataProviderClass = MultFunctionDataProvider.class)
    public void multiplicationTest(double firstArgument, double secondArgument, double expectedResult) {
        double actualResult = calculator.mult(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult, ACCURACY);
    }
}
