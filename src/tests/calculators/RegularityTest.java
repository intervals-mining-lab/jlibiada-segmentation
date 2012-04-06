package tests.calculators;

import base.IntervalType;
import base.sequencies.Chain;
import calculators.Regularity;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.02.12
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
public class RegularityTest extends TestCase {

    public void testCalculate1() {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "AA", "GCCCCTTATTT", "CAGGT"));
        Regularity regularity = new Regularity();
        regularity.setIntervalType(IntervalType.SIMPLE);
        result = regularity.calculate(chain);
        target = 0.7552700090359216;
        assertEquals(result, target);
    }

    @Test
    public void testCalculate2()  {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "AA", "CAGGT"));
        Regularity regularity = new Regularity();
        regularity.setIntervalType(IntervalType.SIMPLE);
        result = regularity.calculate(chain.getUniformChain("AA"));
//        System.out.println(result);
        assertEquals(result, target);

    }
}
