package tests.calculators;

import base.Characteristic;
import base.sequencies.Chain;
import base.sequencies.UniformChain;
import calculators.Calculator;
import calculators.CharacteristicsFactory;
import calculators.Gamut;
import calculators.GeometricAverageInterval;
import junit.framework.TestCase;
import org.junit.Test;
import tools.PerformanceProfiler;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 14.10.2011
 * Time: 17:30:41
 * To change this template use File | Settings | File Templates.
 */
public class GeometricAverageIntervalTest extends TestCase {
    private Chain chain = new Chain("AACAGGTGCCCCTT");
    private UniformChain uchain;

    @Test
    public void testCalculate1() {
        double result;
        double target;
        GeometricAverageInterval gi = new GeometricAverageInterval();
        result = Calculator.calculate(CharacteristicsFactory.get(Characteristic.GEOMETRIC_AVERAGE_INTERAVAL), chain);
        PerformanceProfiler.start();
        result = gi.calculate(chain);
        PerformanceProfiler.end();
 /*       System.out.println("Result = " + result);
        System.out.println("Spent time = " + PerformanceProfiler.result());*/

        target = Math.pow(2.0, (new Gamut().calculate(chain)) / (double)chain.length());
        assertEquals(result, target);
    }

    @Test
    public void testCalculate2() {
        double result;
        double target;
        GeometricAverageInterval gi = new GeometricAverageInterval();
        result =Calculator.calculate(Characteristic.GEOMETRIC_AVERAGE_INTERAVAL,  (uchain = chain.getUniformChain(0)));
        PerformanceProfiler.start();
        result = gi.calculate(uchain);
        PerformanceProfiler.end();
        /*System.out.println("Result = " + result);
        System.out.println("Spent time = " + PerformanceProfiler.result());*/
         target = Math.pow(2.0, 1.0 / 3.0);
        assertEquals(result, target);
    }

    @Test
    public void testGetName() {
        System.out.println("Зайка");
    }
}
