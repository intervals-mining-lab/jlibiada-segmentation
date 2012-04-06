package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import calculators.DescriptiveInformation;
import model.threshold.ThresholdVariator;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 27.12.2011
 * Time: 15:19:51
 * To change this template use File | Settings | File Templates.
 */

/**
 * The criterion of minimum regularity.
 * Allows you to identify the most irregular chain.
 */
public class CriterionMinimumRegularity extends Criterion {
    private DescriptiveInformation regularity;

    {
        regularity = new DescriptiveInformation();
        lastDistortion = Double.MAX_VALUE;
        formalismType = Formalism.CRITERION_MIN_REGULARITY;
    }

    /**
     * init
     *
     * @param threshold A rule for handle a threshold value
     * @param precision additional value to
     */
    public CriterionMinimumRegularity(ThresholdVariator threshold, double precision) {
        super(threshold, precision);
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        double distortion = distortion(chain, alphabet);
        if (Math.abs(lastDistortion) > Math.abs(distortion)) {
            this.chain = chain.clone();
            this.alphabet = alphabet.clone();
            lastDistortion = distortion;
            thresholdToStop.saveBest();
        }
        return (thresholdToStop.distance() > ThresholdVariator.PRECISION);
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        return regularity.calculate(chain);
    }
}
