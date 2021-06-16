package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcAddFunctionTest extends CommonConditions {

    @Test(groups = {Tags.ADD_SUB_OPERATIONS},
          dataProvider = Tags.SUM_DATA_PROVIDER_NAME,
          dataProviderClass = SumFunctionDataProvider.class)
    public void summationTest(double firstArgument, double secondArgument, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.sum(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
