package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import model.threshold.ThresholdVariator;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 01.03.12
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */

/**
 * The criterion of "golden ratio". The basis is the standard law of the golden ratio,
 * where most of the - power of the alphabet and less - the maximum frequency of the word.
 */
public class CriterionGoldenRatio extends Criterion{
    {
        formalismType = Formalism.CRITERION_GOLDEN_RATIO;
        lastDistortion = Double.MAX_VALUE;
    }


    /**
     * init
     *
     * @param threshold A rule for handle a threshold value
     * @param precision additional value to
     */
    public CriterionGoldenRatio(ThresholdVariator threshold, double precision) {
        super(threshold, precision);

    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        double current = distortion(chain, alphabet);
        if (lastDistortion > current) {
            lastDistortion = current;
            this.chain = chain.clone();
            this.alphabet = alphabet.clone();
            thresholdToStop.saveBest();
        }
        return (thresholdToStop.distance() > ThresholdVariator.PRECISION);
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        double greaterToSmaler = 1;
        double sumToGreater = 1;
        double maxFrequency = maxFrequency(alphabet);
        double power = alphabet.power();

        greaterToSmaler = power / maxFrequency;
        sumToGreater = (power + maxFrequency) / power;
        
        return Math.abs(greaterToSmaler - sumToGreater);
    }
    
    private int maxFrequency(Alphabet alphabet){
        int max = 0;
        for(ArrayList<Integer> positions: alphabet.getWordsPositions()){
            if (max < positions.size()) max = positions.size();
        }
        return max;
    }

}
