package testNG_test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testNG_examples.Calculator;

public class MyFirstTest {

    @Test
    public void calculatorSumTest(){
        int a = 4;
        int b = 3;

        int exepectedResult = 7;
        int actualResult = Calculator.sum(4,3);

        Assert.assertEquals(actualResult, exepectedResult);
    }
    @Test
    public void emptyTest() {

    }

    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "^/ by zero$")
    public void devideByZeroTest(){
        int a = 4;
        int b = 0;

        Calculator.divide(a,b);
    }
}
