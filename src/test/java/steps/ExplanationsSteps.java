package steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Тогда;
import org.testng.Assert;

public class ExplanationsSteps {
    private int result;

    @Дано("я скаладываю (.+) и (.+)")
    public void calculate(int oneNumber, int twoNumber) {
            result = oneNumber + twoNumber;
    }

    @Если("я вычитаю из (.+) число (.+)")
    public void subtract(int first, int second) {
        result = first - second;
    }

    @Тогда("в результате я получаю (.+)")
    public void assertResult(int expected) {
        Assert.assertEquals(result, expected);
    }
}
