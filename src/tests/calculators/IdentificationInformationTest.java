package tests.calculators;

import base.sequencies.Chain;
import calculators.IdentificationInformation;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.02.12
 * Time: 18:30
 * To change this template use File | Settings | File Templates.
 */
public class IdentificationInformationTest extends TestCase {
    @Test
    public void testCalculate1() {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "AA", "CAGGT"));
        IdentificationInformation identificationInformation = new IdentificationInformation();
        result = identificationInformation.calculate(chain.getUniformChain("AA"));
        target = 1;
//        System.out.println(result);
        assertEquals(result, target);

    }

    @Test
    public void testCalculate2() {
        double result = 0;
        double target = 0;

        Chain chain = new Chain(Arrays.asList("AA", "CAGGT", "AA", "CAGGT"));
        IdentificationInformation identificationInformation = new IdentificationInformation();
        result = identificationInformation.calculate(chain);
        target = 1;
//        System.out.println(result);
        assertEquals(result, target);

    }
}
