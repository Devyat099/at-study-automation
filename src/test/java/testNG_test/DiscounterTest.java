package testNG_test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG_examples.Discounter;

public class DiscounterTest {

    @DataProvider(name = "positiveProvider")
    public static Object[][] positiveProvider(){
        return new Object[][]{
                {0, 10},
                {49, 10},
                {50, 20},
                {51, 20},
                {99, 20},
                {100, 30},
                {101, 30},
        };
    }


    @Test(dataProvider = "positiveProvider")
    public void positiveDiscounterTest(int money, int expectedDiscount){
        int actualDiscount = Discounter.calculate(money);
        Assert.assertEquals(actualDiscount, expectedDiscount);
    }

}
