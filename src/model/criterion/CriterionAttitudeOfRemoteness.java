package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import calculators.Remoteness;
import calculators.WordAverageLength;
import model.threshold.ThresholdVariator;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 26.12.2011
 * Time: 23:27:23
 * To change this template use File | Settings | File Templates.
 */

/**
 * Provides search for a criterion of integrity the following rule
 * Average word length is no more than the ratio of log2(Interval(M))/log2(Interval(m))
 */

public class CriterionAttitudeOfRemoteness extends Criterion {
    private WordAverageLength wordAverageLength;
    private Remoteness remoteness;

    {
        lastDistortion = Double.MIN_VALUE;
        wordAverageLength = new WordAverageLength();
        remoteness = new Remoteness();
        formalismType = Formalism.CRITERION_ATTITUDE_REMOTENESS;
    }

    /**
     * init
     *
     * @param threshold A rule for handle a threshold value
     * @param precision additional value to
     */
    public CriterionAttitudeOfRemoteness(ThresholdVariator threshold, double precision) {
        super(threshold, precision);
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        double distortion = distortion(chain, alphabet);
        if (Math.abs(lastDistortion) < Math.abs(distortion)){
            this.chain = chain.clone();
            this.alphabet = alphabet.clone();
            lastDistortion = distortion;
            thresholdToStop.saveBest();
        }


        return (thresholdToStop.distance() > ThresholdVariator.PRECISION);
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        return (remoteness.calculate(chain) / remoteness.calculate(chain.original()))
                -  wordAverageLength.calculate(chain) ;

    }
}
