package model.threshold;

import base.Formalism;
import model.criterion.Criterion;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 18.10.2011
 * Time: 12:58:47
 * To change this template use File | Settings | File Templates.
 */
public class ThresholdRandom extends ThresholdVariator {
    {
        formalismType = Formalism.THRESHOLD_RANDOM_METHOD;
    }

    /**
     * @param leftBound  the left bound of threshold
     * @param rightBound the right bound of threshold
     */
    public ThresholdRandom(double leftBound, double rightBound) {
        super(leftBound, rightBound);
    }

    @Override
    public double next(Criterion criterion) {
        return 0;
    }


}
