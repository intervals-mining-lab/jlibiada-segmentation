package tests.calculators;

import base.Anchor;
import base.Characteristic;
import base.sequencies.Chain;
import calculators.Calculator;
import calculators.CharacteristicsFactory;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 10.10.2011
 * Time: 22:44:04
 * To change this template use File | Settings | File Templates.
 */
public class VolumeTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");

    @Test
    public void testCalculate1() {
        int[] intervalA = {1, 1, 2, 11};
        int[] intervalG = {5, 1, 2};
        int[] intervalC = {3, 6, 1, 1, 1};
        int[] intervalT = {7, 6, 1, 2, 1, 1};
        long volume = 332640;
        int result;
        chain.setAnchor(Anchor.START);
        result = (int) Calculator.calculate(CharacteristicsFactory.get(Characteristic.VOLUME), chain);
        assertTrue(volume == result);
    }

    @Test
    public void testCalculate2() {
        // Add your code here
    }

    @Test
    public void testGetName() {
        // Add your code here
    }
}
