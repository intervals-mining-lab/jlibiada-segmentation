package tests.calculators;

import base.IntervalType;
import base.sequencies.Chain;
import calculators.Periodicity;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.02.12
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class PeriodicityTest extends TestCase {
    public void testCalculate1() {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("A1", "A2"));
        Periodicity regularity = new Periodicity();
        regularity.setIntervalType(IntervalType.SIMPLE);
        result = regularity.calculate(chain);
        target = Math.sqrt(2) / 2;
//        System.out.println(result);
        assertEquals(result, target);
    }

    @Test
    public void testCalculate2()  {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "AA", "CAGGT"));
        Periodicity regularity = new Periodicity();
        regularity.setIntervalType(IntervalType.SIMPLE);
        result = regularity.calculate(chain.getUniformChain("AA"));
        target = Math.sqrt(2) / 2;;
//        System.out.println(result);
        assertEquals(result, target);

    }
}
