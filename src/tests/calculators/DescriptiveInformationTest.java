package tests.calculators;

import org.junit.Test;
import calculators.DescriptiveInformation;
import base.sequencies.Chain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 27.12.2011
 * Time: 14:07:42
 * To change this template use File | Settings | File Templates.
 */
public class DescriptiveInformationTest {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    @Test
    public void testCalculate() {
        double result = 0;
        double target;
        DescriptiveInformation regular = new DescriptiveInformation();
        result = regular.calculate(chain);
        System.out.println("DescriptiveInformation = " + result);
        List<String> list = Arrays.asList("A", "S", "A", "A");
        Chain chain = new Chain(list);
        result = regular.calculate(chain);
        System.out.println("DescriptiveInformation = " + result);

    }
}
