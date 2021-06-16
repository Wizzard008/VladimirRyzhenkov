package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcSubFunctionTest extends CommonConditions {

    @Test(groups = {Tags.ADD_SUB_OPERATIONS},
          dataProvider = Tags.SUB_DATA_PROVIDER_NAME,
          dataProviderClass = SubFunctionDataProvider.class)
    public void subtractionTest(double firstArgument, double secondArgument, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.sub(firstArgument, secondArgument);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
