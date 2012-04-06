package model.criterion;

import base.collectors.Alphabet;
import base.Formalism;
import base.sequencies.Chain;
import calculators.Gamut;
import calculators.GamutDeep;
import model.threshold.ThresholdVariator;

import static calculators.Calculator.calculate;

/**
 * Created by IntelliJ IDEA.
 * User: Neestell
 * Date: 16.12.2011
 * Time: 15:01:14
 * To change this template use File | Settings | File Templates.
 */

/**
 * Criterion "Equaty of depths". Goal to find a chain with the same amount of information
 */
public class CriterionEqualityOfDepths extends Criterion{
    private GamutDeep gamutDeep;
    private Gamut gamut;

    {
        gamut = new Gamut();
        gamutDeep = new GamutDeep();
        lastDistortion = Double.MIN_VALUE;
        formalismType = Formalism.CRITERION_EQUALITY_DEPTHS;
    }

    /**
     * init
     *
     * @param threshold A rule for handle a threshold value
     * @param precision additional value to
     */
    public CriterionEqualityOfDepths(ThresholdVariator threshold, double precision) {
        super(threshold, precision);
    }

    @Override
    public boolean state(Chain chain, Alphabet alphabet) {
        double currentDistortion = calculate(gamut, chain) -  calculate(gamutDeep, chain);
        if (Math.abs(currentDistortion) > lastDistortion){
            this.chain = chain.clone();
            this.alphabet = alphabet.clone();
            thresholdToStop.saveBest();
            lastDistortion = currentDistortion;
        }
        return (thresholdToStop.distance() > ThresholdVariator.PRECISION);
    }

    @Override
    public double distortion(Chain chain, Alphabet alphabet) {
        return calculate(gamut, chain.original()) -  calculate(gamutDeep, chain);
    }

}
