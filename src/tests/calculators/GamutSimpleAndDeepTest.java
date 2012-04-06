package tests.calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import calculators.Calculator;
import calculators.Gamut;
import calculators.GamutDeep;
import junit.framework.TestCase;
import org.junit.Test;
import tools.PerformanceProfiler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 12.10.2011
 * Time: 17:34:40
 * To change this template use File | Settings | File Templates.
 */
public class GamutSimpleAndDeepTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTTATTT");
    private UniformChain uchain;

    @Test
    public void testLog2() {
        Gamut g = new Gamut();
        PerformanceProfiler.start();
        Calculator.log2(2);
        PerformanceProfiler.end();
//        System.out.println(" Spent time " + PerformanceProfiler.result());
        assertTrue(Calculator.log2(2) == 1);
    }

    @Test
    public void testGamutSimpleChainAndUniform() {
        double resultForChain;
        double resultForUniformChain;
        double targetForChain;
        double targetForUniformChain;
        Gamut g = new Gamut();
        List<String> list = Arrays.asList("AA", "CAGGT", "AA", "GCCCCTTATTT", "CAGGT");
        Chain chain = new Chain(list);
        UniformChain uniformChain = chain.getUniformChain("AA");

        resultForUniformChain = Calculator.calculate((Characteristic.GAMUT_SIMPLE), uniformChain);
        resultForChain = Calculator.calculate(g, chain);

        targetForChain = log2(1) + log2(2) + log2(2) + log2(4) + log2(3);
        targetForUniformChain = log2(1) + log2(2);
        assertEquals(targetForChain, resultForChain);
        assertEquals(targetForUniformChain, resultForUniformChain);
    }



    public void testGamutDeepChainAndUniform() {
        double resultForChain;
        double resultForUniformChain;
        double targetForChain;
        double targetForUniformChain;
        GamutDeep g = new GamutDeep();
        List<String> list = Arrays.asList("AA", "CAGGT", "AA", "GCCCCTTATTT", "CAGGT");
        Chain chain = new Chain(list);
        UniformChain uniformChain = chain.getUniformChain("AA");

        resultForUniformChain = Calculator.calculate((Characteristic.GAMUT_DEEP), uniformChain);
        resultForChain = Calculator.calculate(g, chain);

        targetForChain = log2(3) + log2(6) + log2(10) + log2(14);
        targetForUniformChain = log2(1) + log2(2);
        assertEquals(targetForChain, resultForChain);
        assertEquals(targetForUniformChain, resultForUniformChain);
    }

    public final double log2(double num) {
        return Math.log(num) / Math.log(2);
    }


}
