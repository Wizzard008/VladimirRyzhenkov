package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcMultFunctionTest extends CommonConditions {

    @Test(groups = {Tags.MULT_DIV_OPERATIONS},
          dataProvider = Tags.MULT_DATA_PROVIDER_NAME,
          dataProviderClass = MultFunctionDataProvider.class)
    public void multiplicationTest(double firstArgument, double secondArgument, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.mult(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
