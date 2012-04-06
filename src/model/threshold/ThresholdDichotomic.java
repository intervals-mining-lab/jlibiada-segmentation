package model.threshold;

import base.Formalism;
import model.criterion.Criterion;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 12:57:39
 * To change this template use File | Settings | File Templates.
 */

/**
 * The threshold changes under the law of decrease the right or left bound on 50 %
 * depending on the external rule
 */
public class ThresholdDichotomic extends ThresholdVariator {
    private double lastDistortion = Double.MAX_VALUE;

    {
        formalismType = Formalism.THRESHOLD_DICHOTOMIC_METHOD;
    }

    /**
     * @param leftBound  the left bound of threshold
     * @param rightBound the right bound of threshold
     */
    public ThresholdDichotomic(double leftBound, double rightBound) {
        super(leftBound, rightBound);
        current = (rightBound + leftBound) / 2.0;
        best = current;
    }

    @Override
    public double next(Criterion criterion) {
        if (rightBound - leftBound > PRECISION) {
            final double criterionDistortion = criterion.distortion();
            if (lastDistortion > criterionDistortion) {
                best = current;
                lastDistortion = criterionDistortion;
            }
            current = (rightBound + leftBound) / 2.0;

            if (criterionDistortion < 0) leftBound = current;
            else rightBound = current;

            return current;
        }
        return -1;
    }
}
