package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import calculators.Calculator;
import model.threshold.ThresholdVariator;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 07.10.2011
 * Time: 1:16:53
 * To change this template use File | Settings | File Templates.
 */

/**
 * A partial Orlov's criterion. Find the difference between
 * the theoretical and practical power of the alphabet
 */
public final class CriterionPartialOrlov extends Criterion {

    {
        formalismType = Formalism.CRITERION_PARTIAL_ORLOV;
        lastDistortion = Double.MAX_VALUE;
        precisionOfDifference = 1;
    }

    /**
     * @param threshold A rule for handle a threshold value
     * @param precision additional value
     */
    public CriterionPartialOrlov(ThresholdVariator threshold, double precision) {
        super(threshold, precision);
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        update(chain, alphabet);
        return (thresholdToStop.distance() > ThresholdVariator.PRECISION) && (Math.abs(distortion(chain, alphabet)) > precisionOfDifference);
    }

    private void update(Chain chain, Alphabet alphabet) {
        double dist = theoryVolume(chain, alphabet) - alphabet.power();
        if (Math.abs(lastDistortion) > Math.abs(dist)) {
            this.alphabet = alphabet.clone();
            this.chain = chain.clone();
            this.lastDistortion = dist;
            thresholdToStop.saveBest();
        }
    }

    @Override
    public double getValue() {
        return lastDistortion;
    }

    public final double distortion(Chain chain, Alphabet alphabet) {
        return theoryVolume(chain, alphabet) - alphabet.power();
    }

    /**
     * Calculates the theoretical volume the alphabet for a chain
     *
     * @param chain    an estimated chain
     * @param alphabet current alphabet
     * @return the theoretical volume the alphabet
     */
    public final double theoryVolume(Chain chain, Alphabet alphabet) {
        final double z;
        final double k;
        final double b;
        final double v;
        double f = 0;
        double freq;
        List<String> wordsList = alphabet.getWords();
        for (String word : wordsList) {
            freq = Calculator.frequency(chain, word);
            if (freq > f) f = freq;
        }
        z = chain.length();
        k = 1 / (Math.log(f * z));
        b = k / f - 1;
        v = k * z - b;
        return v;
    }

    public final double theoryFrequency(int rang, double b, double k) {
        return k / (b + (double) rang);
    }

    public final double calcB(double k, double f1) {
        return ((k / f1) - 1.0);
    }

    public final double calcK(int factFrequency, int length) {
        return 1.0 / Math.log(factFrequency * length);
    }

}
