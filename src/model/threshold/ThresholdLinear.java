package model.threshold;

import base.Formalism;
import extended.ConflictData;
import model.criterion.Criterion;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 06.10.2011
 * Time: 1:08:37
 * To change this template use File | Settings | File Templates.
 */

/**
 * The threshold changes under the law of decrease the right bound
 * upon concrete value
 */
public final class ThresholdLinear extends ThresholdVariator {
    private double step;
    {
        formalismType = Formalism.THRESHOLD_LINEAR_METHOD;
    }

    /**
     * @param leftBound  the left bound of threshold
     * @param rightBound the right bound of threshold
     * @param step       a value which threshold will be changed
     */
    public ThresholdLinear(double leftBound, double rightBound, double step) {
        super(leftBound, rightBound);
        try {
            if ((step > (Math.abs(rightBound - leftBound))) || (leftBound > rightBound)) throw new ConflictData();
        }
        catch (ConflictData ignored) {

        }
        this.step = step;
        current = this.rightBound;
    }

    @Override
    public double next(Criterion criterion) {
        if (this.current > this.leftBound) {
            this.current = this.rightBound;
            this.rightBound = this.rightBound - this.step;
            return current;
        }
        return -1;
    }
}
