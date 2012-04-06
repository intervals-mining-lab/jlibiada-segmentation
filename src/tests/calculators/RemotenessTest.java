package tests.calculators;

import base.IntervalType;
import base.sequencies.Chain;
import calculators.Remoteness;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.02.12
 * Time: 18:47
 * To change this template use File | Settings | File Templates.
 */
public class RemotenessTest extends TestCase {
    @Test
    public void testCalculate1() throws Exception {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "AA", "CAGGT"));
        Remoteness remoteness = new Remoteness();
        remoteness.setIntervalType(IntervalType.SIMPLE);
        result = remoteness.calculate(chain.getUniformChain("AA"));
        target = 0.5000000000000001;
        System.out.println(result);
        assertEquals(result, target);
    }

    @Test
    public void testCalculat2() throws Exception {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "A"));
        Remoteness remoteness = new Remoteness();
        remoteness.setIntervalType(IntervalType.SIMPLE);
        result = remoteness.calculate(chain);
        target = 0.8616541669070519;
        System.out.println(result);
        assertEquals(result, target);
    }
}
