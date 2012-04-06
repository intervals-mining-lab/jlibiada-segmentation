package tests;

import org.junit.Test;
import model.criterion.Criterion;
import model.threshold.ThresholdLinear;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 06.10.2011
 * Time: 1:28:10
 * To change this template use File | Settings | File Templates.
 */
public class ThresholdLinearTest extends TestCase {
    @Test
    public void testNext() {
        double left = 0;
        double right = 1;
        double step = 0.10;
        double current;
        double[] steps = {1.0, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.0};
        int index = 0;
        Criterion criterion = null;
        ThresholdLinear threshold = null;
        threshold = new ThresholdLinear(left, right, step);

        while ((current = threshold.next(criterion)) > 0 ){
           assertTrue((current - steps[index++]) < step);
        }
    }
}
