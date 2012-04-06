package model.criterion;

import base.collectors.Alphabet;
import base.sequencies.Chain;
import model.threshold.ThresholdVariator;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 05.04.12
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class CriterionShrederByWords extends Criterion{
    /**
     * init
     *
     * @param threshold A rule for handle a threshold value
     * @param precision additional value to
     */
    public CriterionShrederByWords(ThresholdVariator threshold, double precision) {
        super(threshold, precision);
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        return false;
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        return 0;
    }
}
