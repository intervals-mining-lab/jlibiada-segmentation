package tests.calculators;

import base.sequencies.Chain;
import base.sequencies.UniformChain;
import calculators.Calculator;
import junit.framework.TestCase;
import org.junit.Test;
import tools.PerformanceProfiler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.10.2011
 * Time: 12:48:29
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest extends TestCase {
    private Chain chain = new Chain("AAAAAAAAAA");
    private UniformChain uniformA = new UniformChain("AA-A----------A---", "A");
    @Test
    public void testFrequency1() {
        double result;
        Calculator calc = new Calculator();
        PerformanceProfiler.start();
        result = calc.frequency(chain, "A");
        PerformanceProfiler.end();
        System.out.printf("Frequency = %f time = %f", result, PerformanceProfiler.result());
    }

    @Test
    public void testFrequency2() {
        double result;
        Calculator calc = new Calculator();
        List<String> list = Arrays.asList("ABC", "BBB", "ABC", "ABC", "BBB", "ABC", "ABC", "BBB", "ABC");
        List<String> list2 = Arrays.asList("ABC", "BBB","ABC");

        chain = new Chain(list);
        PerformanceProfiler.start();
        result = calc.frequency(chain, list2);
        PerformanceProfiler.end();
        System.out.printf("Frequency = %f time = %f", result, PerformanceProfiler.result());
    }
}