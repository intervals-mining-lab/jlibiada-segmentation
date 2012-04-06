package tests;

import base.collectors.Alphabet;
import org.junit.Test;
import junit.framework.TestCase;
import model.criterion.CriterionPartialOrlov;
import model.threshold.ThresholdLinear;
import base.sequencies.Chain;
import tools.PerformanceProfiler;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 13.10.2011
 * Time: 16:08:50
 * To change this template use File | Settings | File Templates.
 */
public class CriterionPartialOrlovTest extends TestCase {
    private Chain chain = new Chain("мамамылараму");
    @Test
    public void testTheoryVolume() {
        double result;
        double k = 0;
        CriterionPartialOrlov orlov = new CriterionPartialOrlov(new ThresholdLinear(1,1,1),1);
        orlov.renew(chain, new Alphabet(chain));
        PerformanceProfiler.start();
        result =    orlov.theoryVolume(chain, new Alphabet(chain));
        PerformanceProfiler.end();
        System.out.printf("spent time = %f\n", PerformanceProfiler.result());
        System.out.printf("result = %f", result);
        k = orlov.calcK(50, 1500);
        System.out.printf("\nresult = %f", orlov.theoryFrequency(2, orlov.calcB(k, 50),  k));
    }
}
