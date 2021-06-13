package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcDivFunctionTest extends CommonConditions {

    @Test(groups = {Tags.MULT_DIV_OPERATIONS}, dataProvider = Tags.DIV_DATA_PROVIDER_NAME,
          dataProviderClass = DivFunctionDataProvider.class)
    public void divideTest(double firstArgument, double secondArgument, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.div(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
