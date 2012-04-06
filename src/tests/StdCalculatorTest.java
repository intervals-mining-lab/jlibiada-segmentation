package tests;

import base.collectors.Alphabet;
import base.sequencies.Chain;
import junit.framework.TestCase;
import model.seeker.ProbabilityExtractor;
import org.junit.Test;

import java.util.List;

import tools.PerformanceProfiler;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 24.10.2011
 * Time: 8:59:56
 * To change this template use File | Settings | File Templates.
 */
public class StdCalculatorTest extends TestCase {
    private Chain chain = new Chain("ABCDDD");
    private Chain vchain = new Chain("ABCDDD");

    @Test
    public void testRun() {
        int balance = 0;
        int winlen = 4;
        double level = 0.1;

        Alphabet alphabet = new Alphabet();
        ProbabilityExtractor calculator = new ProbabilityExtractor();
      //  calculator.find(chain, level, balance, winlen, alphabet);

        System.out.println("3 len");

       // calculator.find(chain, level, balance, winlen - 1, alphabet);
    }

    @Test
    public void testRun2() {
        int balance = 0;
        int winlen = 4;
        double level = 0.1;
        List<String> word;
        Chain chain = new Chain("111121D1221C1B1181P1C187141Q1D15151A1Q149051111");
        Alphabet alphabet = new Alphabet();
        ProbabilityExtractor calculator = new ProbabilityExtractor();
        PerformanceProfiler.start();
     //   word = calculator.find(chain, level, balance, winlen, alphabet).getKey();
        PerformanceProfiler.end();
       // System.out.println("/n Found "+ word + " time " + PerformanceProfiler.result());
    }
}
