package model.threshold;

import base.Formalism;
import interfaces.Definable;
import model.criterion.Criterion;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 05.10.2011
 * Time: 20:16:37
 * To change this template use File | Settings | File Templates.
 */

/**
 * A rule for handle a threshold value
 */
public abstract class ThresholdVariator implements Definable {
    public final static double PRECISION = 0.01;
    protected double leftBound;
    protected double rightBound;
    protected double current;
    protected double best = 0;
    protected Formalism formalismType;

    /**
     * @param leftBound  the left bound of threshold
     * @param rightBound the right bound of threshold
     */
    public ThresholdVariator(double leftBound, double rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    /**
     * Calculates a new value of the threshold subject to taken criterion
     *
     * @param criterion a rule subject to the threshold changes
     * @return the new value of threshold
     */
    public abstract double next(Criterion criterion);

    /**
     * Returns the difference between the right and left bounds
     *
     * @return the difference between the right and left bounds
     */
    public final double distance() {
        return (this.rightBound - this.leftBound);
    }

    @Override
    public double getValue() {
        return best;
    }

    /**
     * Fix the best value
     */
    public void saveBest() {
        best = current;
    }

    public String getName(){
        return formalismType.getName();
    }


}
