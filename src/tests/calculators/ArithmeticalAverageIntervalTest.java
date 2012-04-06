package tests.calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import calculators.ArithmeticalAverageInterval;
import calculators.Calculator;
import calculators.CharacteristicsFactory;
import junit.framework.TestCase;
import org.junit.Test;
import tools.PerformanceProfiler;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.10.2011
 * Time: 16:38:33
 * To change this template use File | Settings | File Templates.
 */
public class ArithmeticalAverageIntervalTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTT");
    private UniformChain uchain;
    @Test
    public void testCalculate() {
        double result;
        double target = chain.length() / 3.0;
        uchain = chain.getUniformChain("A");
        ArithmeticalAverageInterval aai = new ArithmeticalAverageInterval();
        PerformanceProfiler.start();
        result = aai.calculate(uchain);
        PerformanceProfiler.end();
    /*    System.out.println("Spent time "+ PerformanceProfiler.result());
        System.out.println("Result "+ result);*/
        assertEquals(result, target);
    }
    public void testCalculate2() {
        double result;
        double target = (chain.length() / 3.0 + chain.length() / 5.0 + chain.length() / 3.0 + chain.length() / 3.0) / 4.0;
        ArithmeticalAverageInterval aai = new ArithmeticalAverageInterval();
        PerformanceProfiler.start();
        result = aai.calculate(chain);
        PerformanceProfiler.end();
        /*System.out.println("Spent time "+ PerformanceProfiler.result());
        System.out.println("Result "+ result);*/
        assertEquals(result, target);
        result = Calculator.calculate(CharacteristicsFactory.get(Characteristic.ARITHMETIC_AVERAGE_INTERAVAL), chain) ;
        assertEquals(result, target);
    }
}
