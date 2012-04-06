package tests.calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import calculators.Calculator;
import calculators.CharacteristicsFactory;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 11.10.2011
 * Time: 18:19:07
 * To change this template use File | Settings | File Templates.
 */
public class LengthTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private UniformChain uchain;
    private static long ts, te;

    @Test
    public void testCalculate1() {
        int result;
        int target;
        ts = System.nanoTime();
        result = (int) Calculator.calculate(CharacteristicsFactory.get(Characteristic.CHAIN_LENGTH), chain);
        te = System.nanoTime();
//        System.out.println((te - ts) / 1e6);
        assertEquals(result, 18);

        ts = System.nanoTime();
        chain.length();
        te = System.nanoTime();

//        System.out.println((te - ts) / 1e6);
    }

    @Test
    public void testCalculate2() {
        int result;
        int target = 4;
        uchain = chain.getUniformChain("A");
        ts = System.nanoTime();
        result = (int) Calculator.calculate(Characteristic.CHAIN_LENGTH, uchain);
        te = System.nanoTime();
//        System.out.println((te - ts) / 1e6);
        assertEquals(result, target);
    }

    @Test
    public void testGetName() {
        // Add your code here
    }
}
